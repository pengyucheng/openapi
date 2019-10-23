package org.xiaoh.data.openapi.auth.visitor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.xiaoh.data.openapi.auth.composite.PriorityNode;
import org.xiaoh.data.openapi.auth.dao.AccountPriorityRelationshipDAO;
import org.xiaoh.data.openapi.auth.dao.PriorityDAO;
import org.xiaoh.data.openapi.auth.dao.RolePriorityRelationshipDAO;
import org.xiaoh.data.openapi.auth.domain.PriorityDO;

/**
 * 
 * @Description: 检查当前权限节点是否有子权限节点
 * @author pengyc
 * @date 2019年10月21日 
 *
 */
public class PriorityNodeRelateCheckVisitor implements PriorityNodeVisitor
{
    /**
     * 标识权限是否被引用
     */
    private Boolean relateCheckResult = false;
    
    /**
     * 权限管理模块DAO组件
     */
    @Autowired
    private PriorityDAO priorityDAO;
    
    /**
     * 账号和权限关系管理模块DAO组件
     */
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
    
    /**
     * 角色和权限关系管理模块DAO组件
     */
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
    
    
    /**
     * <p>Description: 权限引用校验构造器</p> 
     * @param priorityDAO
     * @param accountPriorityRelationshipDAO
     * @param rolePriorityRelationshipDAO
     */
    public PriorityNodeRelateCheckVisitor(PriorityDAO priorityDAO,
            AccountPriorityRelationshipDAO accountPriorityRelationshipDAO,
            RolePriorityRelationshipDAO rolePriorityRelationshipDAO)
    {
        super();
        this.priorityDAO = priorityDAO;
        this.accountPriorityRelationshipDAO = accountPriorityRelationshipDAO;
        this.rolePriorityRelationshipDAO = rolePriorityRelationshipDAO;
    }

    
    @Override
    public void visit(PriorityNode node) throws Exception
    {
        List<PriorityDO> priorityDOs = priorityDAO.listChildPriorities(node.getId());
        if(null != priorityDOs && priorityDOs.size() > 0)
        {
            for (PriorityDO priorityDO : priorityDOs)
            {
                PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
                priorityNode.accept(this);
            }
        }
        if(checkRelation(node))
        {
            relateCheckResult = true;
        }
    }

    /**
     * 
     * @Description: 检查当前权限是否被引用~即被账号或者角色引用
     * @param node PriorityNode
     * @return true 被引用
     */
    private Boolean checkRelation(PriorityNode node)
    {
        Long accountPriorityCnts = accountPriorityRelationshipDAO.getCountByPriorityId(node.getId());
        Long rolePriorityCnts = rolePriorityRelationshipDAO.getCountByPriorityId(node.getId());
        if((null != accountPriorityCnts && accountPriorityCnts > 0) || (null != rolePriorityCnts && rolePriorityCnts > 0))
        {
            return true; 
        }
        return false;
    }
    
    /**
     * 
     * @Description: getRelateCheckResult
     * @return 获取校验结果
     */
    public Boolean getRelateCheckResult()
    {
        return relateCheckResult;
    }
}
