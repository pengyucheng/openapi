package org.xiaoh.data.openapi.inventory.service;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaoh.data.openapi.inventory.StockUpdateMessage;
import org.xiaoh.data.openapi.inventory.async.StockUpdateQueue;
import org.xiaoh.data.openapi.inventory.async.StockUpdateResultManager;
import org.xiaoh.data.openapi.inventory.constant.GoodsStockUpdateOperation;
import org.xiaoh.data.openapi.inventory.stock.PurchaseInputStockUpdaterFactory;
import org.xiaoh.data.openapi.inventory.stock.StockUpdater;
import org.xiaoh.data.openapi.inventory.stock.SubmitOrderStockUpdaterFactory;
import org.xiaoh.data.openapi.order.domain.OrderInfoDTO;
import org.xiaoh.data.openapi.wms.domain.PurchaseInputOrderDTO;

/**
 * @Description: 库存中心对外接口实现类
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: InventoryServiceImpl
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService
{
    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    
    /**
     * 采购入库库存更新命令工厂类
     */
    @Autowired
    private PurchaseInputStockUpdaterFactory purchaseInputStockUpdaterFactory;
    
    /**
     * 订单提交库存更新命令工厂类
     */
    @Autowired
    private SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory;
    
    /**
     * 商品库存更新队列
     */
    @Autowired
    private StockUpdateQueue goodsStockUpdateQueue;
    
    /**
     * 商品库存更新管理组件
     */
    @Autowired
    private StockUpdateResultManager stockUpdateResultManager;
    
    /**
     * @Description: 通知库存中心，"采购入库"事件发生了
     * @param purcharInputOrderItemDTO
     * @return 
     */
    @Override
    public Boolean informPurchaseInputFinished(PurchaseInputOrderDTO purcharInputOrderDTO)
    {
        try
        {
            StockUpdater stockUpdater = purchaseInputStockUpdaterFactory.create(purcharInputOrderDTO);  
            stockUpdater.updateGoodsStock();
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e);
            return false;
        }
        
        return true;
    }

    /**
     * @Description: informSubmitOrderEvent
     * @param orderDTO
     * @return 通知库存中心，"提交订单"事件发生了
     */
    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO)
    {
        try
        {
            // 更新本地库存
            StockUpdater stockUpdater = submitOrderStockUpdaterFactory.create(orderDTO);
            stockUpdater.updateGoodsStock();
            
            // 异步向内存队列中发送订单提交消息
            StockUpdateMessage message = new StockUpdateMessage();
            message.setId(UUID.randomUUID().toString());
            message.setOperation(GoodsStockUpdateOperation.SUBMIT_ORDER);
            message.setParameter(orderDTO); 
            
            goodsStockUpdateQueue.put(message);
            
            // 监听异步处理结果
            stockUpdateResultManager.observe(message.getId());
        }
        catch(Exception e)
        {
            logger.error("error", e);
            return false;
        }
        
        return true;
    }

}
