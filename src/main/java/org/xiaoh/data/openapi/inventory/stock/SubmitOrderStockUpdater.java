package org.xiaoh.data.openapi.inventory.stock;

import java.util.List;
import java.util.Map;

import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;
import org.xiaoh.data.openapi.order.domain.OrderItemDTO;

/**
 * @Description: 订单提交库存更新命令
 * @author pengyc
 * @date 2019年11月5日 
 * @ClassName: SubmitOrderStockUpdater
 *
 */
public class SubmitOrderStockUpdater extends AbstractStockUpdater
{
    /**
     * key:skuId value:OrderItemDTO
     */
    private Map<Long, OrderItemDTO> skuId2OrderItemDTO;
    
    public SubmitOrderStockUpdater(List<GoodsStockDO> goodsStockDOs, GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider, Map<Long, OrderItemDTO> skuId2OrderItemDTO)
    {
        super(goodsStockDOs, goodsStockDAO, dateProvider);
        this.skuId2OrderItemDTO = skuId2OrderItemDTO;
    }

    /**
     * 更新销售库存
     */
    @Override
    protected void updateSaleStockQuantity()
    {
        for (GoodsStockDO goodsStockDO : goodsStockDOs)
        {
            OrderItemDTO orderItemDTO = skuId2OrderItemDTO.get(goodsStockDO.getGoodsSkuId());
            goodsStockDO.setSaleStockQuantity(goodsStockDO.getSaleStockQuantity() - orderItemDTO.getPurchaseQuantity());
        }
    }

    /**
     * 更新锁定库存
     */
    @Override
    protected void updateLockedStockQuantity()
    {
        for (GoodsStockDO goodsStockDO : goodsStockDOs)
        {
            OrderItemDTO orderItemDTO = skuId2OrderItemDTO.get(goodsStockDO.getGoodsSkuId());
            goodsStockDO.setLockedStockQuantity(goodsStockDO.getLockedStockQuantity() + orderItemDTO.getPurchaseQuantity());
        }
  
    }

    @Override
    protected void updateSaledStockQuantity()
    {
    }

}
