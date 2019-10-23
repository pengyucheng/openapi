package org.xiaoh.data.openapi.order.validator;

import org.xiaoh.data.openapi.order.domain.CommonReqParam;

/**
 * 
 * @Description: 参数校验器
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: ParamValidator
 *
 */
public interface ParamValidator
{
    void validate(CommonReqParam baseReqParam);
}
