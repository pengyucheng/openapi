package org.xiaoh.data.openapi.common.util;

/**
 * 
 * @Description: 响应状态枚举类
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: ResponseStatus
 *
 */
public enum ResponseStatus
{
    /*
     * 请求成功
     */
    SUCCESS("success", 0), 
    
    /*
     * 请求参数异常
     */
    REQ_PARAM_EXP("request param value illegal ,please recheck it ", -1),
    
    /*
     * 服务器端异常
     */
    SERVER_EXP("server is busy , request 5 mins later", -2);
    
    /*
     * 响应消息
     */
    private String msg;
    
    /*
     * 状态码
     */
    private int status;
    
    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    private ResponseStatus(String msg, int status)
    {
        this.msg = msg;
        this.status = status;
    }
    
    public static String getMsg(int status)
    {
        for(ResponseStatus rstatus: ResponseStatus.values())
        {
            if(rstatus.getStatus() == status)
            {
                return rstatus.msg;
            }
        }
        return null;
    }
}
