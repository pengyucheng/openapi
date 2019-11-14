package org.xiaoh.data.openapi.inventory.async;

import java.util.Observable;

/**
 * @Description: 商品库存更新结果观察目标
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateObservable
 *
 */
public class StockUpdateObservable extends Observable
{
    private String messageId;
    
    public StockUpdateObservable(String messageId)
    {
        this.messageId = messageId;
    }
    
    /**
     * @Description: 设置商品库存更新结果
     * @param result 商品库存更新结果
     */
    public void setResult(Boolean result)
    {
        StockUpdateResult goodsStockUpdateResult = new StockUpdateResult();
        goodsStockUpdateResult.setMessageId(messageId);
        goodsStockUpdateResult.setResult(result);
        this.setChanged();
        this.notifyObservers(goodsStockUpdateResult);
    }

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }
    
}

