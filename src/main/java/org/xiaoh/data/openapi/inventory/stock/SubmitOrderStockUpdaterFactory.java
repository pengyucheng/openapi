package org.xiaoh.data.openapi.inventory.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;
import org.xiaoh.data.openapi.order.domain.OrderInfoDTO;
import org.xiaoh.data.openapi.order.domain.OrderItemDTO;

/**
 * @Description: 订单提交库存更新命令工厂
 * @author pengyc
 * @date 2019年11月13日
 * @ClassName: SubmitOrderStockUpdaterFactory
 *
 */
@Component
public class SubmitOrderStockUpdaterFactory extends AbstractStockUpdaterFactory<OrderInfoDTO>
{

    /**
     * <p>
     * Description: 构造器
     * </p>
     * 
     * @param goodsStockDAO
     * @param dateProvider
     */
    public SubmitOrderStockUpdaterFactory(GoodsStockDAO goodsStockDAO, DateProvider dateProvider)
    {
        super(goodsStockDAO, dateProvider);
        this.goodsStockDAO = goodsStockDAO;
        this.dateProvider = dateProvider;
    }

    /**
     * 创建提交订单库存更新命令
     */
    @Override
    protected StockUpdater create(List<GoodsStockDO> goodStockDOs, OrderInfoDTO paramter) throws Exception
    {
        Map<Long, OrderItemDTO> skuId2OrderItemDTO = new HashMap<Long, OrderItemDTO>();
        List<OrderItemDTO> orderItemDTOs = paramter.getOrderItems();
        for (OrderItemDTO orderItemDTO : orderItemDTOs)
        {
            skuId2OrderItemDTO.put(orderItemDTO.getGoodsSkuId(), orderItemDTO);
        }
        return new SubmitOrderStockUpdater(goodStockDOs, goodsStockDAO, dateProvider, skuId2OrderItemDTO);
    }

    /**
     * 获取订单相关的商品skuId集合
     */
    @Override
    protected List<Long> getGoodSkuId(OrderInfoDTO paramter) throws Exception
    {
        List<OrderItemDTO> orderItems = paramter.getOrderItems();
        List<Long> skuIds = new ArrayList<Long>(orderItems.size());
        for (OrderItemDTO orderItemDTO : orderItems)
        {
            skuIds.add(orderItemDTO.getGoodsSkuId());
        }
        return skuIds;
    }

}
