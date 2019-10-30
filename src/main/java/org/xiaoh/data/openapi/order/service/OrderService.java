package org.xiaoh.data.openapi.order.service;

/**
 * 
 * @Description: 订单中心对外提供的接口
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: OrderService
 *
 */
public interface OrderService
{
    /**
     * @Description: 通知订单中心，“订单发表评论”事件发生了
     * @param orderId
     * @return true 成功发表评论
     */
    Boolean informPublishCommentEvent(Long orderId);
}
