package org.xiaoh.data.openapi.order.controller;

/**
 * 
 * @Description: 响应构造器工厂类
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: ResponseBuildFactory
 *
 */
public class ResponseBuildFactory
{
    /**
     * 
     * @Description: 后续如果有多个 ResponseBuilder实体类，可在 build方法加一个参数，以区分具体实现
     * @return ResponseBuilder
     */
    public static ResponseBuilder create()
    {
        return new OrderQtyResponseBuilder();
    }
}
