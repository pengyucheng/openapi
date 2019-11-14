package org.xiaoh.data.openapi.inventory.stock;

/**
 * @Description: 商品库存更新命令的接口
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: StockUpdater
 *
 */
public interface StockUpdater
{
    /**
     * @Description: 更新商品库存
     * @return 处理结果
     */
    Boolean updateGoodsStock();
}
