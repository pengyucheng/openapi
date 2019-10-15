package org.xiaoh.data.openapi.controller;

/**
 * 
 * @Description: 响应消息构造器基类
 * @author pengyc
 * @date 2019年8月27日 
 * @ClassName: BaseResponseBuilder
 * 
 * @param <T>
 */
public abstract class BaseResponseBuilder implements ResponseBuilder
{
    protected Response response = new Response();
    
    @Override
    public ResponseBuilder status(int value)
    {
        response.setStatus(value);
        return this;
    }

    @Override
    public ResponseBuilder msg(String msg)
    {
        response.setMsg(msg);
        return this;
    }

    @Override
    public ResponseBuilder apiName(String apiName)
    {
        response.setApiName(apiName);
        return this;
    }

    @Override
    public Response build()
    {
        return this.response;
    }

}
