package org.xiaoh.data.openapi.auth.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.xiaoh.data.openapi.auth.dao.AccountPriorityRelationshipDAO;
import org.xiaoh.data.openapi.auth.mapper.AccountPriorityRelationshipMapper;

/**
 * 
 * @Description: 账号和权限关系管理模块的DAO组件
 * @author pengyc
 * @date 2019年10月21日
 *
 */
@Repository
public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO
{

    private static final Logger logger = LoggerFactory.getLogger(AccountPriorityRelationshipDAOImpl.class);

    /**
     * 账号和权限关系管理模块的mapper组件
     */
    @Autowired
    private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;

    /**
     * 根据权限id查询记录数
     * 
     * @param priorityId 权限id
     * @return 记录数
     */
    @Override
    public Long getCountByPriorityId(Long priorityId)
    {
        try
        {
            return accountPriorityRelationshipMapper.getCountByPriorityId(priorityId);
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e);
        }
       
        return null;
    }

}
