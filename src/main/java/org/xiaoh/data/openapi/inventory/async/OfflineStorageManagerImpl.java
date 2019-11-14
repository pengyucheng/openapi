package org.xiaoh.data.openapi.inventory.async;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.StockUpdateMessage;
import org.xiaoh.data.openapi.inventory.constant.GoodsStockUpdateOperation;
import org.xiaoh.data.openapi.inventory.dao.StockUpdateMessageDAO;
import org.xiaoh.data.openapi.inventory.domain.StockUpdateMessageDO;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description: 离线存储管理器实现类 
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: OfflineStorageManagerImpl
 *
 */
@Component
public class OfflineStorageManagerImpl implements OfflineStorageManager
{
    /**
     * 库存更新消息管理模块DAO组件
     */
    @Autowired
    private StockUpdateMessageDAO stockUpdateMessageDAO;
    /**
     * 日期辅助组件
     */
    @Autowired
    private DateProvider dateProvider;
    /**
     * 是否触发离线存储的标识
     */
    private Boolean offline = false;
    
    /**
     * 离线存储库存更新消息
     */
    @Override
    public void store(StockUpdateMessage message) throws Exception
    {
        StockUpdateMessageDO stockUpdateMessageDO = createStockUpdateMessageDO(message);
        stockUpdateMessageDAO.save(stockUpdateMessageDO);
    }

    /**
     * @Description: 创建 StockUpdateMessageDO
     * @param message
     * @return 
     * @throws ParseException 
     */
    private StockUpdateMessageDO createStockUpdateMessageDO(StockUpdateMessage message) throws ParseException
    {
        StockUpdateMessageDO messageDO = new StockUpdateMessageDO();
        messageDO.setMessageId(message.getId());
        messageDO.setOperation(GoodsStockUpdateOperation.SUBMIT_ORDER);
        messageDO.setParamterClazz(message.getParameter().getClass().getName());
        messageDO.setParamter(JSONObject.toJSONString(message.getParameter()));
        messageDO.setGmtCreate(dateProvider.getCurrentTime());
        messageDO.setGmtModified(dateProvider.getCurrentTime());
        return messageDO;
    }

    /**
     * 获取离线存储标识
     */
    @Override
    public Boolean getOffline() throws Exception
    {
        return offline;
    }

    /**
     * 设置离线存储标识
     */
    @Override
    public void setOffline(Boolean offline) throws Exception
    {
        this.offline = offline;
    }

    /**
     * 获取离线数据迭代器
     */
    @Override
    public OfflineStorageIterator iterator() throws Exception
    {
        return new OfflineStorageIteratorImpl();
    }

    /**
     * 批量删除库存更新消息
     */
    @Override
    public void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) throws Exception
    {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < stockUpdateMessages.size(); i++)
        {
            builder.append(stockUpdateMessages.get(i).getId());
            if(i < stockUpdateMessages.size() - 1)
            {
                builder.append(",");
            }
        }
        stockUpdateMessageDAO.removeByBatch(builder.toString());
    }

    /**
     * @Description: 离线数据遍历器
     * @author pengyc
     * @date 2019年11月13日 
     * @ClassName: OfflineStorageIteratorImpl
     *
     */
    public class OfflineStorageIteratorImpl implements OfflineStorageIterator
    {
        /**
         * 判断是否还有下一批库存更新消息
         */
        @Override
        public boolean hasNext() throws Exception
        {
            return stockUpdateMessageDAO.count().equals(0L) ? false : true;
        }

        /**
         * 获取下一批库存更新消息
         */
        @Override
        public List<StockUpdateMessage> next() throws Exception
        {
            List<StockUpdateMessage> messages = new ArrayList<StockUpdateMessage>();
            List<StockUpdateMessageDO> messageDOs = stockUpdateMessageDAO.listByBatch();
            for (StockUpdateMessageDO stockUpdateMessageDO : messageDOs)
            {
                StockUpdateMessage message = new StockUpdateMessage();
                message.setId(stockUpdateMessageDO.getMessageId());
                message.setOperation(stockUpdateMessageDO.getOperation());
                message.setParameter(stockUpdateMessageDO.getParamter());
                messages.add(message);
            }
            
            return messages;
        }
        
    }
}
