package org.xiaoh.data.openapi.auth.service;

import java.util.List;

import org.xiaoh.data.openapi.auth.domain.PriorityDTO;

/**
 * 
 * @Description: 权限管理模块的service组件接口
 * @author pengyc
 * @date 2019年10月21日
 *
 */
public interface PriorityService
{
    /**
     * 查询根权限
     * @return 根权限集合
     */
    List<PriorityDTO> listRootPriorities() throws Exception;
    
    /**
     * 
     * @Description: 删除权限
     * @param id 权限ID
     */
    Boolean removePriority(Long id) throws Exception;
    
    /**
     * 
     * @Description: 新增权限
     * @param priorityDO 
     */
    void savePriority(PriorityDTO priorityDTO) throws Exception;
    
    /**
     * 
     * @Description: 更新权限
     * @param priorityDO
     */
    void updatePriority(PriorityDTO priorityDTO) throws Exception;
}
