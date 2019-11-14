package org.xiaoh.data.openapi.inventory.dao;

import org.apache.ibatis.annotations.Param;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;

/**
 * 
 * @Description: 库存管理模块DAO组件
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: GoodsStockDAO
 *
 */
public interface GoodsStockDAO
{
    /**
     * 更新商品库存
     * @param goodsStockDO 商品库存DO对象
     */
    void updateGoodsStock(GoodsStockDO goodsStockDO) throws Exception;
    
    /**
     * 新增商品库存
     * @param goodsStockDO 商品库存DO对象
     */
    void saveGoodsStock(GoodsStockDO goodsStockDO) throws Exception;

    /**
     * 根据商品sku id查询商品库存
     * @param goodsSkuId 商品sku id
     * @return 商品库存
     */
    GoodsStockDO getGoodsStockBySkuId(@Param("goodsSkuId") Long goodsSkuId) throws Exception;
}
