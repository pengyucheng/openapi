package org.xiaoh.data.openapi.inventory;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.async.StockUpdateObservable;
import org.xiaoh.data.openapi.inventory.async.StockUpdateObserver;
import org.xiaoh.data.openapi.inventory.async.StockUpdateQueue;
import org.xiaoh.data.openapi.inventory.async.StockUpdateResult;
import org.xiaoh.data.openapi.inventory.async.StockUpdateResultManager;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;
import org.xiaoh.data.openapi.inventory.service.InventoryService;
import org.xiaoh.data.openapi.order.domain.OrderInfoDTO;
import org.xiaoh.data.openapi.order.domain.OrderItemDTO;

/**
 * @Description: 库存中心service组件的单元测试类
 * @author pengyc
 * @date 2019年11月5日 
 * @ClassName: InventoryServiceTest
 * 
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class InventoryServiceTest
{
    /**
     * 库存中心service组件
     */
    @Autowired
    private InventoryService inventoryService;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;
    /**
     * 商品库存管理DAO组件
     */
    @Autowired
    private GoodsStockDAO goodsStockDAO;
    /**
     * 库存更新消息队列
     */
    @Autowired
    private StockUpdateQueue stockUpdateQueue;
    /**
     * 库存更新结果管理组件
     */
    @Autowired
    private StockUpdateResultManager stockUpdateResultManager;
    /**
     * 库存更新结果监听组件
     */
    @MockBean
    private StockUpdateObserver stockUpdateObserver;

    /**
     * @Description: 测试订单提交库存更新命令
     * @throws Exception
     */
    @Test
    public void testInformSubmitOrderEvent() throws Exception
    {
        Long[] goodSkuIds = new Long[] {10L};
        Long oldSaleStockQty = 100L;
        Long oldlockStockQty = 50L;
        Long oldSaledStockQty = 200L;
        Long purchaseQuantity = 5L;
        
        for(Long goodsSkuId : goodSkuIds)
        {
            createGoodsStock(goodsSkuId, oldSaleStockQty,
                    oldlockStockQty,oldSaledStockQty);
        }
        
        // 更新本地库存
        OrderInfoDTO orderInfo = createOrder(goodSkuIds, purchaseQuantity);
        inventoryService.informSubmitOrderEvent(orderInfo);
        for(Long goodsSkuId : goodSkuIds)
        {
            assertEquals((long)oldSaleStockQty - purchaseQuantity,(long)getSaleStockQuantity(goodsSkuId));
        }
        
        // 异步通知
         assertAsyncOperation();
    }

    /**
     * @throws Exception 
     * @Description: 测试异步发送订单提交消息
     */
    private void assertAsyncOperation() throws Exception
    {
        assertEquals(1, (int)stockUpdateQueue.size());
        StockUpdateMessage message = stockUpdateQueue.take();
       
        StockUpdateObservable observable = stockUpdateResultManager.getObservable(message.getId());
        
        StockUpdateResult result = new StockUpdateResult();
        result.setMessageId(message.getId());
        result.setResult(true);
       
        stockUpdateResultManager.inform(message.getId(), true);
        
        Mockito.verify(stockUpdateObserver, Mockito.times(1)).update(observable, result);
    }

    /**
     * @Description: 获取
     * @param goodSkuId
     * @return
     * @throws Exception
     */
    private Long getSaleStockQuantity(Long goodSkuId) throws Exception
    {
        GoodsStockDO stock = goodsStockDAO.getGoodsStockBySkuId(goodSkuId);
        if(stock == null)
        {
            return 0L;
        }
        else
        {
            return stock.getSaleStockQuantity();
        }
    }
    /**
     * @Description: 创建订单
     * @param goodSkuIds
     * @param purchaseQuantity
     * @return
     * @throws ParseException 
     */
    private OrderInfoDTO createOrder(Long[] goodSkuIds, Long purchaseQuantity) throws ParseException
    {
        OrderInfoDTO order = new OrderInfoDTO();
        order.setId(1L);
        order.setUsername("pengyc");
        order.setUserAccountId(1L);
        order.setOrderNo("test");
        order.setOrderStatus(1);
        order.setConsignee("hwb");
        order.setDeliveryAddress("TCL科技大厦");
        order.setConsigneeCellPhoneNumber("18899876799");
        order.setFreight(50.00);
        order.setPayType(1);
        order.setTotalAmount(9999.99);
        order.setDiscountAmount(99.99);
        order.setCouponAmount(99.0);
        order.setPayableAmount(9900.0);
        order.setInvoiceTitle("TCL科技大厦");
        order.setTaxpayerId("纳税人识别号");
        order.setOrderComment("老板很开心");
        order.setPublishedComment(1);
        order.setConfirmReceiptTime(dateProvider.getCurrentTime());
        order.setGmtCreate(dateProvider.getCurrentTime());
        order.setGmtModified(dateProvider.getCurrentTime());
        
        List<OrderItemDTO> items = new ArrayList<>();
        for (int i = 0; i < goodSkuIds.length; i++)
        {
            items.add(createOrderItem(1L, (long) i, goodSkuIds[i],purchaseQuantity));
        }
        order.setOrderItems(items);
        
        return order;
    }

    /**
     * @Description: 订单项
     * @param orderId
     * @param itemId
     * @param goodsSkuId
     * @param purchaseQuantity
     * @return
     * @throws ParseException 
     */
    private OrderItemDTO createOrderItem(long orderId, Long itemId, Long goodsSkuId, Long purchaseQuantity) throws ParseException
    {
        OrderItemDTO item = new OrderItemDTO();
        item.setOrderInfoId(orderId);
        item.setGoodsId(1L);
        item.setGoodsSkuId(goodsSkuId);
        item.setGoodsSkuCode("编号");
        item.setGoodsName("手绘画");
        item.setSaleProperties("测试销售属性");
        item.setGoodsGrossWeight(3.33);
        item.setPurchaseQuantity(purchaseQuantity);
        item.setPurchasePrice(318.00);
        item.setPromotionActivityId(1L);
        item.setGoodsLenght(90.00);
        item.setGoodsWidth(30.00);
        item.setGoodsHeight(90.00);
        item.setGmtCreate(dateProvider.getCurrentTime());
        item.setGmtModified(dateProvider.getCurrentTime());
        return item;
    }

    /**
     * @Description: 初始化商品库存
     * @param goodsSkuId
     * @param oldSaledStockQty
     * @param oldlockStockQty
     * @param oldSaledStockQty2
     * @throws Exception 
     */
    private void createGoodsStock(Long goodsSkuId, Long oldSaleStockQty, Long oldlockStockQty, Long oldSaledStockQty) throws Exception
    {
        GoodsStockDO stock = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId);
        if(null == stock)
        {
            stock = new GoodsStockDO();
            stock.setGoodsSkuId(goodsSkuId);
            stock.setSaledStockQuantity(oldSaledStockQty);
            stock.setSaleStockQuantity(oldSaleStockQty);
            stock.setLockedStockQuantity(oldlockStockQty);
            stock.setStockStatus(oldSaleStockQty > 0L ? 1 : 0);
            stock.setGmtCreate(dateProvider.getCurrentTime());
            stock.setGmtModified(dateProvider.getCurrentTime());
            goodsStockDAO.saveGoodsStock(stock);
        }
        else
        {
            stock.setGoodsSkuId(goodsSkuId);
            stock.setSaledStockQuantity(oldSaledStockQty);
            stock.setSaleStockQuantity(oldSaleStockQty);
            stock.setLockedStockQuantity(oldlockStockQty);
            stock.setStockStatus(oldSaleStockQty > 0L ? 1 : 0);
            stock.setGmtModified(dateProvider.getCurrentTime());
            goodsStockDAO.updateGoodsStock(stock);
        }
        
    }
}
