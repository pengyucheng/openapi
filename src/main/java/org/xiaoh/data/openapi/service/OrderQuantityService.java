package org.xiaoh.data.openapi.service;

import org.xiaoh.data.openapi.controller.ResponseData;
import org.xiaoh.data.openapi.domain.OrderQuantityDTO;
import org.xiaoh.data.openapi.domain.OrderQuantityQuery;

/**
 * 
 * @Description: OrderQuantity Service层接口
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: OrderQuantityService
 *
 */
public interface OrderQuantityService
{
    /**
     * 
     * @Description: 根据订单日期，分页查询订单开票数量相关信息
     * @param orderQuantityQuery 
     * @return 订单开票数量相关信息
     * @throws Exception 
     */
    ResponseData<OrderQuantityDTO> selectPage(OrderQuantityQuery requestParam) throws Exception;
}
