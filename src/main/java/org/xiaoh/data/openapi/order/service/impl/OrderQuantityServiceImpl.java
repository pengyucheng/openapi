package org.xiaoh.data.openapi.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaoh.data.openapi.order.controller.ResponseData;
import org.xiaoh.data.openapi.order.dao.OrderQuantityDAO;
import org.xiaoh.data.openapi.order.domain.OrderQuantityDTO;
import org.xiaoh.data.openapi.order.domain.OrderQuantityQuery;
import org.xiaoh.data.openapi.order.domain.PageInfo;
import org.xiaoh.data.openapi.order.service.OrderQuantityService;
import org.xiaoh.data.openapi.common.util.MapObjUtil;

/**
 * 
 * @Description: 订单消费类 service组件
 * @author pengyc
 * @date 2019年8月23日
 * @ClassName: OrderQuantityServiceImpl
 *
 */
@Service
public class OrderQuantityServiceImpl implements OrderQuantityService
{
    /*
     * OrderQuantity DAO组件
     */
    @Autowired
    private OrderQuantityDAO orderQuantityDAO;

    /**
     *  分页查询 OrderQuantityDTO相关信息
     * @throws Exception 
     */
    @Override
    public ResponseData<OrderQuantityDTO> selectPage(OrderQuantityQuery requestParam) throws Exception
    {
        ResponseData<OrderQuantityDTO> responseBody = new ResponseData<>();
        PageInfo pageInfo = orderQuantityDAO.selectPage(requestParam);
        
        List<Map<String, Object>> resultList = pageInfo.getResultList();
        List<OrderQuantityDTO> orderQuantityDTOs = new ArrayList<OrderQuantityDTO>(resultList.size());
        for (Map<String, Object> map : resultList)
        {
            OrderQuantityDTO orderQuantityDTO = (OrderQuantityDTO) MapObjUtil.map2obj2(map, OrderQuantityDTO.class);
            orderQuantityDTOs.add(orderQuantityDTO);
        }
        assignResponseBody(responseBody, pageInfo, orderQuantityDTOs);

        return responseBody;
    }

    /**
     * 
     * @Description: 给ResponseBody对象赋值
     * @param responseBody
     * @param pageInfo
     * @param orderQuantityDTOs
     */
    private void assignResponseBody(ResponseData<OrderQuantityDTO> responseBody, PageInfo pageInfo,
            List<OrderQuantityDTO> orderQuantityDTOs)
    {
        responseBody.setResult(orderQuantityDTOs);
        responseBody.setPageNum(pageInfo.getCurrentPage());
        responseBody.setTotalSize(pageInfo.getTotalRows());
        boolean hasNext = pageInfo.getTotalPages() - pageInfo.getCurrentPage() > 0 ? true : false;
        responseBody.setHasNext(hasNext);
    }

}
