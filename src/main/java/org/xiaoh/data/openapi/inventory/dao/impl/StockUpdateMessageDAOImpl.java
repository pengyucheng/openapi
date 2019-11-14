package org.xiaoh.data.openapi.inventory.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaoh.data.openapi.inventory.dao.StockUpdateMessageDAO;
import org.xiaoh.data.openapi.inventory.domain.StockUpdateMessageDO;
import org.xiaoh.data.openapi.inventory.mapper.StockUpdateMessageMapper;

/**
 * @Description: 库存更新消息DAO实现类
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateMessageDAOImpl
 *
 */
@Repository
public class StockUpdateMessageDAOImpl implements StockUpdateMessageDAO
{
    /**
     * 库存更新消息管理模块 mapper 组件
     */
    @Autowired
    private StockUpdateMessageMapper stockUpdateMessageMapper;
    
    @Override
    public void save(StockUpdateMessageDO stockUpdateMessageDO) throws Exception
    {
        stockUpdateMessageMapper.save(stockUpdateMessageDO);
    }

    @Override
    public List<StockUpdateMessageDO> listByBatch() throws Exception
    {
        return stockUpdateMessageMapper.listByBatch();
    }

    @Override
    public void removeByBatch(String ids) throws Exception
    {
        stockUpdateMessageMapper.removeByBatch(ids);
    }

    @Override
    public Long count() throws Exception
    {
        return stockUpdateMessageMapper.count();
    }
    
}
