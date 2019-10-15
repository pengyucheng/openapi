package org.xiaoh.data.openapi.controller;

/**
 * 
 * @Description: 响应结果构造器
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: ResponseBuilder
 * 
 * @param <T>
 */
public interface ResponseBuilder
{
    ResponseBuilder status(int value);

    ResponseBuilder msg(String msg);
    
    ResponseBuilder apiName(String apiName);
    
    ResponseBuilder responseData(ResponseData<?> data);
    
    <T> Response<T> build();
}
