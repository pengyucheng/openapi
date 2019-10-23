package org.xiaoh.data.openapi.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.xiaoh.data.openapi.order.domain.OrderQuantityDTO;
import org.xiaoh.data.openapi.order.domain.OrderQuantityVO;

/**
 * 
 * @Description: 订单开票响应构造器实现类
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: OrderResponseBuilder
 *
 */
public class OrderQtyResponseBuilder extends BaseResponseBuilder implements ResponseBuilder
{

    @Override
    public ResponseBuilder responseData(ResponseData<?> data)
    {
        @SuppressWarnings("unchecked")
        List<OrderQuantityDTO> orderQtyDTOs = (List<OrderQuantityDTO>) data.getResult();
        List<OrderQuantityVO> orderQtyVOs = new ArrayList<OrderQuantityVO>(data.getResult().size());
        for (OrderQuantityDTO orderQtyDTO : orderQtyDTOs)
        {
            OrderQuantityVO orderQuantityVO = new OrderQuantityVO();
            orderQuantityVO.setArea(orderQtyDTO.getArea());
            orderQuantityVO.setBillingQty(orderQtyDTO.getBilling_qty());
            orderQuantityVO.setOrgId(orderQtyDTO.getOrg_id());
            orderQuantityVO.setPeriodId(orderQtyDTO.getPeriod_id());
            orderQtyVOs.add(orderQuantityVO);
        }
        ResponseData<OrderQuantityVO> resDataVO = new ResponseData<>();
        resDataVO.setHasNext(data.isHasNext());
        resDataVO.setPageNum(data.getPageNum());
        resDataVO.setTotalSize(data.getTotalSize());
        resDataVO.setResult(orderQtyVOs);
        response.setData(resDataVO);
        
        return this;
    
    }

}
