package org.xiaoh.data.openapi.auth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.xiaoh.data.openapi.auth.dao.PriorityDAO;
import org.xiaoh.data.openapi.auth.domain.PriorityDO;
import org.xiaoh.data.openapi.auth.mapper.PriorityMapper;

/**
 * 
 * @Description: 权限管理组件DAO实现类
 * @author pengyc
 * @date 2019年10月21日
 *
 */
@Repository
public class PriorityDAOImpl implements PriorityDAO
{
    @Autowired
    private PriorityMapper priorityMapper;

    /**
     * 查询根权限
     * 
     * @return 根权限集合
     */
    @Override
    public List<PriorityDO> listRootPriorities() throws Exception
    {
        return priorityMapper.listRootPriorities();
    }

    /**
     * @Description: 删除权限
     * @param id 权限ID
     */
    public Boolean removePriority(Long id) throws Exception
    {
        return priorityMapper.removePriority(id);
    }

    /**
     * @Description: 根据ID查询子根权
     * @param id 子权限集合
     */
    @Override
    public List<PriorityDO> listChildPriorities(Long priorityId) throws Exception
    {
        return priorityMapper.listchildPriorities(priorityId);
    }

    /**
     * @Description: 根据ID查询权限
     * @param Id 权限ID
     * @return 权限
     */
    @Override
    public PriorityDO getPriorityById(Long Id) throws Exception
    {
        return priorityMapper.getPriorityById(Id);
    }

    /**
     * @Description: 更新权限
     * @param priorityDO
     */
    @Override
    public void updatePriority(PriorityDO priorityDO) throws Exception
    {
        priorityMapper.updatePriority(priorityDO);
    }

    /**
     * @Description: 新增权限
     * @param priorityDO
     */
    @Override
    public void savePriority(PriorityDO priorityDO) throws Exception
    {
        priorityMapper.savePriority(priorityDO);
    }

}
