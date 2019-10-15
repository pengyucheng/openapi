package org.xiaoh.data.openapi.validator;

import org.xiaoh.data.openapi.domain.CommonReqParam;

/**
 * 
 * @Description: 参数校验器基类
 * @author pengyc
 * @date 2019年8月26日
 * @ClassName: AbstractParamValidator
 *
 */
public abstract class BaseParamValidator implements ParamValidator
{
    /**
     * 
     * @Description: 所有的公共参数在这里校验
     * @param baseReqParam CommonReqParam
     */
    void commonValidate(CommonReqParam baseReqParam)
    {
        try
        {
            Integer pageNum = Integer.valueOf(baseReqParam.getPageNum());
            Integer pageSize = Integer.valueOf(baseReqParam.getPageSize());

            // pageNum < 0 => pageNum = 0
            if (0 >= pageNum)
            {
                baseReqParam.setPageNum("1");
            }
            // pageSize < 0 => pageSize = 100
            if (0 >= pageSize)
            {
                baseReqParam.setPageSize("250");
            }
        } catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("value of pageNum or pageSize should be number,but actual value is " + baseReqParam, e);
        }
    }

}
