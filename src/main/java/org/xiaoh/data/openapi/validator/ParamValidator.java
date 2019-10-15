package org.xiaoh.data.openapi.validator;

import org.xiaoh.data.openapi.domain.CommonReqParam;

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
