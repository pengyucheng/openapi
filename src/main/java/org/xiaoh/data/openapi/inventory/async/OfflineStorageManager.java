package org.xiaoh.data.openapi.inventory.async;

import java.util.List;

import org.xiaoh.data.openapi.inventory.StockUpdateMessage;

/**
 * @Description: 离线存储管理器
 * @author pengyc
 * @date 2019年11月11日 
 * @ClassName: OfflineStorageManager
 *
 */
public interface OfflineStorageManager
{
    /**
     * @Description: 离线存储库存更新消息
     * @param message
     * @throws Exception
     */
    void store(StockUpdateMessage message) throws Exception;
    /**
     * @Description: 获取离线存储标识
     * @return
     * @throws Exception
     */
    Boolean getOffline() throws Exception;
    /**
     * @Description: 设置离线存储标识
     * @param offline
     * @throws Exception
     */
    void setOffline(Boolean offline) throws Exception;
    
    /**
     * @Description: 获取迭代器
     * @return
     * @throws Exception
     */
    OfflineStorageIterator iterator() throws Exception;
    
    /**
     * @Description: 批量删除库存更新消息
     * @param stockUpdateMessages
     * @throws Exception
     */
    void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) throws Exception;
}
