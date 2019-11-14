package org.xiaoh.data.openapi.inventory.async;

/**
 * @Description: 库存更新结果管理类
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateResultManager
 *
 */
public interface StockUpdateResultManager
{
    /**
     * @Description: 设置对商品库存更新结果的观察
     * @param messageId
     */
    void observe(String messageId);
    
    /**
     * @Description: 获取商品库存更新结果的观察目标
     * @param messageId
     * @param result
     */
    void inform(String messageId, Boolean result);
    
    /**
     * @Description: 获取库存更新结果观察目标
     * @param messageId
     * @return
     */
    StockUpdateObservable getObservable (String messageId);
}
