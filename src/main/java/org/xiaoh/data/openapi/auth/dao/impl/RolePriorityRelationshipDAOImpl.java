package org.xiaoh.data.openapi.auth.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.xiaoh.data.openapi.auth.dao.RolePriorityRelationshipDAO;
import org.xiaoh.data.openapi.auth.mapper.RolePriorityRelationshipMapper;

/**
 * 
 * @Description: 角色和权限关系管理模块的DAO组件
 * @author pengyc
 * @date 2019年10月21日
 *
 */
@Repository
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO
{
    private static final Logger logger = LoggerFactory.getLogger(RolePriorityRelationshipDAOImpl.class);

    @Autowired
    private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;

    @Override
    public Long getCountByPriorityId(Long priorityId)
    {
        try
        {
            return rolePriorityRelationshipMapper.getCountByPriorityId(priorityId);
        } catch (Exception e)
        {
            logger.error(e.toString(), e);
        }

        return null;
    }

}
