package org.xiaoh.data.openapi.inventory.async;

import org.xiaoh.data.openapi.inventory.StockUpdateMessage;

/**
 * @Description: 商品库存更新消息的队列接口
 * @author pengyc
 * @date 2019年11月11日 
 * @ClassName: StockUpdateQueue
 *
 */
public interface StockUpdateQueue
{
    /**
     * @Description: 将一条消息放入队列
     * @param message
     * @throws Exception
     */
    void put(StockUpdateMessage message) throws Exception;
    /**
     * @Description: 直接将消息放入队列
     * @param message
     * @throws Exception
     */
    void putDirect(StockUpdateMessage message) throws Exception;
    
    /**
     * @Description: 从队列中取出一个消息
     * @return
     * @throws Exception
     */
    StockUpdateMessage take() throws Exception;
    
    /**
     * @Description: 获取队列大小
     * @return 队列大小
     * @throws Exception
     */
    Integer size() throws Exception;
}
