package org.xiaoh.data.openapi.inventory.stock;

/**
 * @Description: 库存更新命令工厂类
 * @author pengyc
 * @date 2019年11月5日 
 * @ClassName: StockUpdaterFactory
 *
 */
public interface StockUpdaterFactory<T>
{
    /**
     * @Description: 生产 StockUpdater
     * @param paramter
     * @return
     * @throws Exception 
     */
    StockUpdater create(T paramter) ;
}
