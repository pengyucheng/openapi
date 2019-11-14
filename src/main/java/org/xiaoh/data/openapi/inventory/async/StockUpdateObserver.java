package org.xiaoh.data.openapi.inventory.async;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 商品库存更新结果观察者
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateObserver
 *
 */
@Component
public class StockUpdateObserver implements Observer
{
    private static final Logger logger = LoggerFactory.getLogger(StockUpdateObserver.class);

    /**
     * 通知异步处理结果
     */
    @Override
    public void update(Observable o, Object arg)
    {
        StockUpdateResult result = (StockUpdateResult) arg;
        logger.info("商品库存更新消息 messageId = " + result.getMessageId() + "]"
                + "的异步处理结果为：" + result.getResult() );
    }

}
