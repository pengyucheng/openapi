package org.xiaoh.data.openapi.auth.dao;

/**
 * 
 * @Description: 账号和权限关系管理模块的DAO组件接口
 * @author pengyc
 * @date 2019年10月21日
 *
 */
public interface AccountPriorityRelationshipDAO
{

    /**
     * 根据权限id查询记录数
     * 
     * @param priorityId 权限id
     * @return 记录数
     */
    Long getCountByPriorityId(Long priorityId);

}
