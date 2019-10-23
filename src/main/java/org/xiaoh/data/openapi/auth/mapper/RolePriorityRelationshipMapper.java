package org.xiaoh.data.openapi.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @Description: 角色权限关系Mapper组件
 * @author pengyc
 * @date 2019年10月18日
 *
 */
@Mapper
public interface RolePriorityRelationshipMapper
{
    
    /**
     * 
     * @Description: getCountByPriorityId
     * @param priorityId
     * @return 记录数
     */
    @Select("SELECT count(*) "
            + "FROM auth_role_priority_relationship " 
     + "WHERE priority_id=#{priorityId} ")
    Long getCountByPriorityId(@Param("priorityId") Long priorityId);
}
