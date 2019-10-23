package org.xiaoh.data.openapi.order.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaoh.data.openapi.order.domain.OrderQuantityDTO;
import org.xiaoh.data.openapi.order.domain.OrderQuantityQuery;
import org.xiaoh.data.openapi.order.domain.OrderQuantityVO;
import org.xiaoh.data.openapi.order.service.OrderQuantityService;
import org.xiaoh.data.openapi.common.util.Constants;
import org.xiaoh.data.openapi.common.util.ResponseStatus;
import org.xiaoh.data.openapi.order.validator.OrderQuantityParamValidator;
import org.xiaoh.data.openapi.order.validator.ParamValidator;

/**
 * 
 * @Description: 订单开票 controller 组件
 * @author xiaoh
 * @date 2019年8月26日
 * @ClassName: OrderQuantityController
 *
 */
@RestController
@RequestMapping("/openapi/v1")
public class OrderQuantityController
{
    private static final Logger logger = LoggerFactory.getLogger(OrderQuantityController.class);

    @Autowired
    private OrderQuantityService orderQuantityService;

    /**
     * 用于获取请求IP等信息
     */
    @Autowired
    private HttpServletRequest httpRequest;

    /**
     * 分页订单数量:利用构造器模式、简单工程模式与模板方法模式优化后的代码
     * 
     * @param query 查询条件
     * @return OrderQuantityResponse
     */
    @GetMapping("/orderQty/excellent")
    public Response<OrderQuantityVO> listByPage(OrderQuantityQuery requestParam)
    {
        if (logger.isWarnEnabled())
        {
            logger.warn("Ip-" + httpRequest.getRemoteHost() + " launch a new [orderQty] request with params-"
                    + requestParam);
        }
        ResponseBuilder resBuilder = (ResponseBuilder) ResponseBuildFactory.create();
        try
        {
            resBuilder.apiName(Constants.API_NAME_ORDERQTY);
            ParamValidator validator = new OrderQuantityParamValidator(requestParam);
            validator.validate(requestParam);
            ResponseData<OrderQuantityDTO> responseData = orderQuantityService.selectPage(requestParam);
            resBuilder.msg(ResponseStatus.SUCCESS.getMsg()).status(ResponseStatus.SUCCESS.getStatus())
                    .responseData(responseData);
            return resBuilder.build();
        } catch (IllegalArgumentException e)
        {
            logger.error("error", e);
            return resBuilder.msg(ResponseStatus.REQ_PARAM_EXP.getMsg())
                    .status(ResponseStatus.REQ_PARAM_EXP.getStatus()).build();
        } catch (Exception e)
        {
            logger.error("error", e);
            return resBuilder.msg(ResponseStatus.SERVER_EXP.getMsg()).status(ResponseStatus.SERVER_EXP.getStatus())
                    .build();
        }
    }

    /**
     * 二黄的第一枚神器:构造者模式
     * 
     * @param query 查询条件
     * @return OrderQuantityResponse
     */
    @GetMapping("/orderQty")
    public Response<OrderQuantityVO> listByPageOK(OrderQuantityQuery requestParam)
    {
        ResponseBuilder resBuilder = new OrderQtyResponseBuilder();
        try
        {
            resBuilder.apiName("orderQty");
            ResponseData<OrderQuantityDTO> responseData = orderQuantityService.selectPage(requestParam);
            return resBuilder.responseData(responseData).msg("success").status(0).build();
        } catch (Exception e)
        {
            logger.error("error", e);
            return resBuilder.msg("fail").status(-1).build();
        }
    }
}
