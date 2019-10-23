package org.xiaoh.data.openapi.auth.visitor;

import java.util.List;
import org.xiaoh.data.openapi.auth.composite.PriorityNode;
import org.xiaoh.data.openapi.auth.dao.PriorityDAO;
import org.xiaoh.data.openapi.auth.domain.PriorityDO;

/**
 * 
 * @Description: 删除权限及其子权限
 * @author pengyc
 * @date 2019年10月21日 
 *
 */
public class PriorityNodeRemoveVisitor implements PriorityNodeVisitor
{
    /**
     * 权限管理DAOA组件
     */
    private PriorityDAO priorityDAO;
    
    
    public PriorityNodeRemoveVisitor(PriorityDAO priorityDAO)
    {
        super();
        this.priorityDAO = priorityDAO;
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
        priorityDAO.removePriority(node.getId()); 
    }

}
