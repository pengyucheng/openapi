package org.xiaoh.data.openapi.inventory.async;

import java.util.concurrent.ArrayBlockingQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xiaoh.data.openapi.inventory.StockUpdateMessage;
/**
 * @Description: 商品库存更新队列实现类
 * @author pengyc
 * @date 2019年11月11日 
 * @ClassName: StockUpdateQueueImpl
 *
 */
@Component
public class StockUpdateQueueImpl implements StockUpdateQueue
{
    /**
     * 队列容量
     */
    private static final Integer QUEUE_MAX_SIZE = 1000;
    /**
     * 商品库存更新队列
     */
    private ArrayBlockingQueue<StockUpdateMessage> queue = 
            new ArrayBlockingQueue<StockUpdateMessage>(QUEUE_MAX_SIZE);
    /**
     * 离线存储管理组件
     */
    @Autowired
    private OfflineStorageManager offlineStorageManager;
    
    /**
     * 向队列中插入一条消息
     */
    @Override
    public void put(StockUpdateMessage message) throws Exception
    {
        // 离线存储，直接写入 mysql
        if(offlineStorageManager.getOffline())
        {
            offlineStorageManager.store(message);
            if(queue.size() == 0)
            {
                new OfflineResumeThread(offlineStorageManager, this).start();
            }
            return;
        }
        // 队列满了，则触发离线存储
        if(QUEUE_MAX_SIZE.equals(queue.size()))
        {
            offlineStorageManager.store(message);
            offlineStorageManager.setOffline(true);
            return;
        }
        
        queue.put(message);
    }

    /**
     * 直接将消息放入队列
     */
    @Override
    public void putDirect(StockUpdateMessage message) throws Exception
    {
        queue.put(message);
    }

    /**
     * 从队列中取出一个消息
     */
    @Override
    public StockUpdateMessage take() throws Exception
    {
        return queue.take();
    }

    /**
     * 获取队列大小
     */
    @Override
    public Integer size() throws Exception
    {
        return queue.size();
    }

}
