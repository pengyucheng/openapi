package org.xiaoh.data.openapi.inventory.async;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaoh.data.openapi.inventory.StockUpdateMessage;

/**
 * @Description: 离线数据恢复线程
 * @author pengyc
 * @date 2019年11月11日 
 * @ClassName: OfflineResumeThread
 *
 */
public class OfflineResumeThread extends Thread
{
    private static final Logger logger = LoggerFactory.getLogger(OfflineResumeThread.class);
      
    /**
     * 离线存储管理组件
     */
    private OfflineStorageManager offlineStorageManager;
    /**
     * 存款更新队列
     */
    private StockUpdateQueue stockUpdateQueue;
    
    public OfflineResumeThread(OfflineStorageManager offlineStorageManager,
            StockUpdateQueue stockUpdateQueue)
    {
        this.offlineStorageManager = offlineStorageManager;
        this.stockUpdateQueue = stockUpdateQueue;
    }
    
    /**
     *  将数据库中的库存更新消息放入内存队列中
     */
    @Override
    public void run()
    {
        try
        {
            OfflineStorageIterator offlineStorageIterator = offlineStorageManager.iterator();
            while(offlineStorageIterator.hasNext())
            {
                try
                {
                    List<StockUpdateMessage> stockUpdateMessages = 
                            offlineStorageIterator.next();
                    for(StockUpdateMessage message : stockUpdateMessages)
                    {
                        stockUpdateQueue.putDirect(message);
                    }
                    offlineStorageManager.removeByBatch(stockUpdateMessages); 
                }
                catch(Exception e)
                {
                    logger.error("error", e);
                }
               
            }  
            offlineStorageManager.setOffline(false);
        }
        catch(Exception e)
        {
            logger.error("error", e);
        }
       
    }
}
