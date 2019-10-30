package org.xiaoh.data.openapi.order.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xiaoh.data.openapi.order.service.OrderService;

/**
 * 
 * @Description: 订单中心对外接口实现类
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: OrderServiceImpl
 *
 */
@Service
public class OrderServiceImpl implements OrderService
{
    private Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Boolean informPublishCommentEvent(Long orderId)
    {
        try 
        {
            
        }
        catch(Exception e)
        {
            log.error(e.toString(), e); 
            return false;
        }
        return true;
    }

}
