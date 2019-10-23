package org.xiaoh.data.openapi.order.controller;

/**
 * 
 * @Description: 响应结构抽象类
 * @author pengyc
 * @date 2019年8月23日
 * @ClassName: AbstractResponse
 *
 */
public class Response<T>
{
    int status;

    String msg;
    
    String apiName;
    
    ResponseData<T> data;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    public ResponseData<T> getData()
    {
        return data;
    }

    public void setData(ResponseData<T> data)
    {
        this.data = data;
    }

}
