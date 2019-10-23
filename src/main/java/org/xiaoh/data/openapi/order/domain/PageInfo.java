package org.xiaoh.data.openapi.order.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @Description: 分页信息
 * @author pengyc
 * @date 2019年8月28日
 * @ClassName: PageInfo
 *
 */
public class PageInfo
{
    /*
     * 一页显示的记录数
     */
    private int pageSize;
    /*
     * 记录总数
     */
    private int totalRows;
    /*
     * 总页数
     */
    private int totalPages;
    /*
     * 当前页码
     */
    private int currentPage;
    /*
     * 起始行数
     */
    private int startIndex;
    /*
     * 结束行数
     */
    private int lastIndex;
    /*
     * 结果集存放List
     */
    private List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();

    public PageInfo(JdbcTemplate jdbcTemplate, String sql, Object[] params, PageParams pageParams)
    {
        setTotalRows(sql, jdbcTemplate, params);
        if (totalRows > 0)
        {
            setPageSize(pageParams.getPageSize() > totalRows ? totalRows : pageParams.getPageSize());
            setTotalPages(totalRows % pageSize == 0 ? (totalRows / pageSize) : (totalRows / pageSize) + 1);
            setCurrentPage(pageParams.getPageNum() > totalPages ? totalPages : pageParams.getPageNum());
            setStartIndex((currentPage - 1) * pageSize);
            setResultList(jdbcTemplate, new StringBuilder(sql), params, pageParams);
        }
    }

    /**
     * 
     * @Description: 查询总记录数
     * @param sql
     * @param jdbcTemplate
     * @param params
     */
    public void setTotalRows(String sql, JdbcTemplate jdbcTemplate, Object[] params)
    {
        String totalRowSql = " select count(*) from ( " + sql + " ) pagetab";
        int totalRows = jdbcTemplate.queryForObject(totalRowSql, params, Integer.class);
        this.totalRows = totalRows;
    }
    
    /**
     * 
     * @Description: 查询当前页内容
     * @param jdbcTemplate
     * @param sql
     * @param params
     * @param pageParams
     */
    public void setResultList(JdbcTemplate jdbcTemplate, StringBuilder sql, 
            Object[] params, PageParams pageParams)
    {
        this.resultList = jdbcTemplate.queryForList(getImpalaPageSQL(sql, pageParams), params);  ;
    }

    /**
     * 构造Impala数据分页SQL
     *
     * @param queryString
     * @return sql string
     */
    private String getImpalaPageSQL(StringBuilder queryString, PageParams pageParam)
    {
        String resultSql = null;
        queryString.append(" order by ").append(pageParam.getSortField()).append(" ");
        resultSql = queryString.append(" limit ").append(pageSize).append(" offset ").append(startIndex).toString();
        return resultSql;
    }
    
    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getStartIndex()
    {
        return startIndex;
    }

    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }

    public int getLastIndex()
    {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex)
    {
        this.lastIndex = lastIndex;
    }

    public List<Map<String, Object>> getResultList()
    {
        return resultList;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalRows()
    {
        return totalRows;
    }
}
