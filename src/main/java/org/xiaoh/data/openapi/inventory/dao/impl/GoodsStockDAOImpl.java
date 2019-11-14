package org.xiaoh.data.openapi.inventory.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;
import org.xiaoh.data.openapi.inventory.mapper.GoodsStockMapper;

/**
 * 
 * @Description: 库存管理模块DAO组件接口实现类
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: GoodsStockDAO
 *
 */
@Repository
public class GoodsStockDAOImpl implements GoodsStockDAO
{
    /**
     *  库存管理mapper组件
     */
    @Autowired
    private GoodsStockMapper goodsStockMapper;
    
    @Override
    public void updateGoodsStock(GoodsStockDO goodsStockDO) throws Exception
    {
        goodsStockMapper.updateGoodsStock(goodsStockDO);
    }

    @Override
    public void saveGoodsStock(GoodsStockDO goodsStockDO) throws Exception
    {
        goodsStockMapper.saveGoodsStock(goodsStockDO);
    }

    @Override
    public GoodsStockDO getGoodsStockBySkuId(Long goodsSkuId) throws Exception
    {
        return goodsStockMapper.getGoodsStockBySkuId(goodsSkuId);
    }

}
