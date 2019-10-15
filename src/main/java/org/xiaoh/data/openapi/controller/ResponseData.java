package org.xiaoh.data.openapi.controller;

import java.util.List;

/**
 * 
 * @Description: 响应消息体
 * @author pengyc
 * @date 2019年8月26日
 * @ClassName: ResponseBody
 * 
 * @param <T>
 */

public class ResponseData<T>
{
    private List<T> result;

    private boolean hasNext;

    private long totalSize;

    private int pageNum;

    public List<T> getResult()
    {
        return result;
    }

    public void setResult(List<T> result)
    {
        this.result = result;
    }

    public boolean isHasNext()
    {
        return hasNext;
    }

    public void setHasNext(boolean hasNext)
    {
        this.hasNext = hasNext;
    }

    public long getTotalSize()
    {
        return totalSize;
    }

    public void setTotalSize(long totalSize)
    {
        this.totalSize = totalSize;
    }

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

}
