package org.xiaoh.data.openapi.domain;

/**
 * 
 * @Description: 分页请求参数
 * @author pengyc
 * @date 2019年8月28日 
 * @ClassName: PageParams
 *
 */
public class PageParams
{
    /**
     * 请求页
     */
    private int pageNum = 1;
    /**
     * 页大小
     */
    private int pageSize = 250;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 升序or降序:默认升序
     */
    private String asc = "asc";
    
    public PageParams(int pageNum, int pageSize, String sortField)
    {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.sortField = sortField;
	}
    
    public int getPageNum()
    {
        return pageNum;
    }
    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }
    public int getPageSize()
    {
        return pageSize;
    }
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    public String getSortField()
    {
        return sortField;
    }
    public void setSortField(String sortField)
    {
        this.sortField = sortField;
    }
    public String getAsc()
    {
        return asc;
    }
    public void setAsc(String asc)
    {
        this.asc = asc;
    }
}
