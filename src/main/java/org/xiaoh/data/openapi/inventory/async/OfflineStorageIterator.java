package org.xiaoh.data.openapi.inventory.async;

import java.util.List;

import org.xiaoh.data.openapi.inventory.StockUpdateMessage;

/**
 * @Description: 离线存储数据迭代器
 * @author pengyc
 * @date 2019年11月11日 
 * @ClassName: OfflineStorageIterator
 *
 */
public interface OfflineStorageIterator
{
    /**
     * @Description: 判断是否还有下一批库存更新消息
     * @return 
     * @throws Exception
     */
    boolean hasNext() throws Exception;
    /**
     * @Description: 获取下一批库存更新消息
     * @return
     * @throws Exception
     */
    List<StockUpdateMessage> next() throws Exception;
}
