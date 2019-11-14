package org.xiaoh.data.openapi.inventory.async;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 商品库存更新结果管理组件
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateResultManagerImpl
 *
 */
@Component
public class StockUpdateResultManagerImpl implements StockUpdateResultManager
{
    /**
     * 商品库存更新结果 map
     */
    private Map<String, StockUpdateObservable> observableMap = new ConcurrentHashMap<>();
    
    /**
     * 商品库存更新结果观察者
     */
    @Autowired
    private StockUpdateObserver observer;
    
    /**
     * 设置对商品库存更新结果的观察
     */
    @Override
    public void observe(String messageId)
    {
        StockUpdateObservable observable = new StockUpdateObservable(messageId);
        observable.addObserver(observer);
        observableMap.put(messageId, observable);
    }

    /**
     * 获取商品库存更新结果的观察目标
     */
    @Override
    public void inform(String messageId, Boolean result)
    {
        StockUpdateObservable observable = observableMap.get(messageId);
        observable.setResult(result);
        observableMap.remove(messageId);
    }

    /**
     * 获取库存更新结果观察目标
     */
    @Override
    public StockUpdateObservable getObservable(String messageId)
    {
        return observableMap.get(messageId);
    }

}
