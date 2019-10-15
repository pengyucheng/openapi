package org.xiaoh.data.openapi.validator;

import org.xiaoh.data.openapi.domain.CommonReqParam;
import org.xiaoh.data.openapi.domain.OrderQuantityQuery;
import org.xiaoh.data.openapi.util.StringUtils;

/**
 * 
 * @Description: 订单开票数量接口参数校验器
 * @author pengyc
 * @date 2019年8月26日
 * @ClassName: OrderQuantityParamValidator
 *
 */
public class OrderQuantityParamValidator extends BaseParamValidator
{

    /*
     * 订单票据请求参数
     */
    private OrderQuantityQuery orderQuantityQuery;

    public OrderQuantityParamValidator(OrderQuantityQuery orderQuantityQuery)
    {
        this.orderQuantityQuery = orderQuantityQuery;
    }

    /**
     * 参数校验器
     */
    @Override
    public void validate(CommonReqParam baseReqParam)
    {
        commonValidate(baseReqParam);
        periodIdValidate(orderQuantityQuery.getPeriodId());
    }

    /**
     * 
     * @Description: periodId 参数值是否合法
     * @param periodId eg.201909
     * @return true or false
     */
    private void periodIdValidate(String periodId)
    {
        if (!(StringUtils.isNumber(periodId) && periodId.length() == 6))
        {
            throw new IllegalArgumentException("Value of periodId :" + periodId + " in request obj com.tcl.data."
                    + "openapi.domain.OrderQuantityQuery is illegal ");
        }
    }

}
