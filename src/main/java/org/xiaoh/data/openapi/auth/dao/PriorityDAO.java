package org.xiaoh.data.openapi.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.xiaoh.data.openapi.auth.domain.PriorityDO;

/**
 * 
 * @Description: 权限管理模块的DAO组件接口
 * @author pengyc
 * @date 2019年10月21日
 *
 */
public interface PriorityDAO
{

    /**
     * 查询根权限
     * 
     * @return 根权限集合
     */
    List<PriorityDO> listRootPriorities() throws Exception;
    
    /**
     * 根据ID查询子根权
     * 
     * @return 子权限集合
     */
    List<PriorityDO> listChildPriorities(Long priorityId) throws Exception;

    /**
     * 
     * @Description: 删除权限
     * @param id 权限ID
     */
    Boolean removePriority(Long id) throws Exception;
    
    /**
     * 
     * @Description: 根据ID查询权限
     * @param Id 权限ID
     * @return 权限
     */
    PriorityDO getPriorityById(@Param("id") Long Id) throws Exception;
    
    /**
     * 
     * @Description: 更新权限
     * @param priorityDO
     */
    void updatePriority(PriorityDO priorityDO) throws Exception;
    
    /**
     * @Description: 新增权限
     * @param priorityDO 
     */
    void savePriority(PriorityDO priorityDO) throws Exception;
}
