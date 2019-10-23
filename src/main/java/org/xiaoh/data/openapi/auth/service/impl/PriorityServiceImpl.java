package org.xiaoh.data.openapi.auth.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaoh.data.openapi.auth.composite.PriorityNode;
import org.xiaoh.data.openapi.auth.dao.AccountPriorityRelationshipDAO;
import org.xiaoh.data.openapi.auth.dao.PriorityDAO;
import org.xiaoh.data.openapi.auth.dao.RolePriorityRelationshipDAO;
import org.xiaoh.data.openapi.auth.domain.PriorityDO;
import org.xiaoh.data.openapi.auth.domain.PriorityDTO;
import org.xiaoh.data.openapi.auth.service.PriorityService;
import org.xiaoh.data.openapi.auth.visitor.PriorityNodeRelateCheckVisitor;
import org.xiaoh.data.openapi.auth.visitor.PriorityNodeRemoveVisitor;
import org.xiaoh.data.openapi.common.util.DateProvider;

/**
 * 
 * @Description: PriorityService 组件实现类
 * @author pengyc
 * @date 2019年10月21日
 *
 */
@Service
public class PriorityServiceImpl implements PriorityService
{
    Logger logger = LoggerFactory.getLogger(PriorityService.class);

    @Autowired
    private DateProvider dateProvider;

    /**
     * 权限管理模块DAO组件
     */
    @Autowired
    private PriorityDAO priorityDAO;

    /**
     * 账号和权限关系管理模块DAO组件
     */
    @Autowired
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;

    /**
     * 角色和权限关系管理模块DAO组件
     */
    @Autowired
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;

    /**
     * 查询根权限
     * 
     * @return 根权限集合
     */
    @Override
    public List<PriorityDTO> listRootPriorities() throws Exception
    {
        List<PriorityDTO> priorityDTOs = null;
        List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities();
        if (null != priorityDOs && priorityDOs.size() > 0)
        {
            priorityDTOs = new ArrayList<PriorityDTO>(priorityDOs.size());
            for (PriorityDO priorityDO : priorityDOs)
            {
                priorityDTOs.add(priorityDO.clone(PriorityDTO.class));
            }
        }
        return priorityDTOs;
    }

    /**
     * 
     * @Description: 根据权限ID删除权限
     * @param id 权限ID
     */
    @Override
    public Boolean removePriority(Long id) throws Exception
    {
        PriorityDO priorityDO = priorityDAO.getPriorityById(id);
        if (null == priorityDO)
        {
            return false; 
        }
        PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
        PriorityNodeRelateCheckVisitor relateCheck = new PriorityNodeRelateCheckVisitor(priorityDAO,
                accountPriorityRelationshipDAO, rolePriorityRelationshipDAO);
        relateCheck.visit(priorityNode);
        Boolean relateResult = relateCheck.getRelateCheckResult();
        if (relateResult)
        {
            logger.info("fail to remove priority - id : " + id);
            return false;
        }
        PriorityNodeRemoveVisitor nodeRemover = new PriorityNodeRemoveVisitor(priorityDAO);
        nodeRemover.visit(priorityNode);
        return true;
    }

    /**
     * 
     * @Description: 新增权限
     * @param priorityDO
     * @throws Exception 
     */
    @Override
    public void savePriority(PriorityDTO priorityDTO) throws Exception 
    {
        priorityDTO.setGmtCreate(dateProvider.getCurrentTime());
        priorityDTO.setGmtModified(dateProvider.getCurrentTime());
        PriorityDO priorityDO = priorityDTO.clone(PriorityDO.class);
        priorityDAO.savePriority(priorityDO);
    }

    /**
     * 
     * @Description: 更新权限
     * @param priorityDO
     * @throws Exception 
     */
    @Override
    public void updatePriority(PriorityDTO priorityDTO) throws Exception
    {
        priorityDTO.setGmtModified(dateProvider.getCurrentTime());
        PriorityDO priorityDO = priorityDTO.clone(PriorityDO.class);
        priorityDAO.updatePriority(priorityDO);
    }
}
