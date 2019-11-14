package org.xiaoh.data.openapi.inventory.service;

import org.xiaoh.data.openapi.order.domain.OrderInfoDTO;
import org.xiaoh.data.openapi.wms.domain.PurchaseInputOrderDTO;

/**
 * @Description: 库存中心对外提供的接口
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: InventoryService
 *
 */
public interface InventoryService
{
    
    /**
     * @Description: 通知库存中心，"采购入库"事件发生了
     * @param purcharInputOrderItemDTO
     * @return 
     */
    Boolean informPurchaseInputFinished(PurchaseInputOrderDTO
             purcharInputOrderDTO);
    
    /**
     * @Description: informSubmitOrderEvent
     * @param orderDTO 4302015187461
     * @return 通知库存中心，"提交订单"事件发生了
     */
    Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO);
}
