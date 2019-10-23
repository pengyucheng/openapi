package org.xiaoh.data.openapi.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @Description: 账号权限关系 Mapper 组件
 * @author pengyc
 * @date 2019年10月21日 
 *
 */
@Mapper
public interface AccountPriorityRelationshipMapper
{
	
	/**
	 * 
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	@Select("SELECT "
	        + "count(*) "
	        + "FROM auth_account_priority_relationship "
			+ "WHERE priority_id=#{priorityId}")
	Long getCountByPriorityId(@Param("priorityId") Long priorityId);

}
