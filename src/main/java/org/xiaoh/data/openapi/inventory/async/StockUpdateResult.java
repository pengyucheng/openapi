package org.xiaoh.data.openapi.inventory.async;

/**
 * @Description: 商品库存更新结果
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateResult
 *
 */
public class StockUpdateResult
{
    /**
     * 商品库存更新消息id
     */
    private String messageId;
    /**
     * 商品库存更新结果
     */
    private Boolean result;
    
    public String getMessageId()
    {
        return messageId;
    }
    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }
    public Boolean getResult()
    {
        return result;
    }
    public void setResult(Boolean result)
    {
        this.result = result;
    }
    
}
