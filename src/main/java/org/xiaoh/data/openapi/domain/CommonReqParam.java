package org.xiaoh.data.openapi.domain;

/**
 * 
 * @Description: 分页公共请求参数
 * @author pengyc
 * @date 2019年8月27日 
 * @ClassName: CommonReqParam
 *
 */
public class CommonReqParam
{
    /**
     * 分页查询起始位置
     */
    String pageNum = "1";
    /**
     * 每页查询记录数
     */
    String pageSize = "250";
    
    public String getPageNum()
    {
        return pageNum;
    }
    public void setPageNum(String pageNum)
    {
        this.pageNum = pageNum;
    }
    public String getPageSize()
    {
        return pageSize;
    }
    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }
    @Override
    public String toString()
    {
        return "CommonReqParam [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
    }
    
}
