package org.xiaoh.data.openapi.dao.impl;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.xiaoh.data.openapi.dao.OrderQuantityDAO;
import org.xiaoh.data.openapi.domain.OrderQuantityQuery;
import org.xiaoh.data.openapi.domain.PageInfo;
import org.xiaoh.data.openapi.domain.PageParams;
import org.xiaoh.data.openapi.util.Constants;

/**
 * 
 * @Description: 订单开票类DAO组件实现类
 * @author pengyc
 * @date 2019年8月28日
 * @ClassName: OrderQtyDAOImpl
 *
 */
@Component
public class OrderQuantityDAOImpl implements OrderQuantityDAO
{
    /**
     * impala 数据源
     */
    @Resource(name = "dataSource")
    private DataSource dataSource;

    /**
     * 订单数据分页查询sql
     */
    private String selectPageOrderQty = "select * from obg_dm.dm_obg_quantity_daily where period_id like ? ";

    /**
     * 分页查询QuantityQuery
     */
    @Override
    public PageInfo selectPage(OrderQuantityQuery requestParam)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PageParams pageParam = new PageParams(Integer.valueOf(requestParam.getPageNum()),
                Integer.valueOf(requestParam.getPageSize()), Constants.PERIOD_ID);
        return new PageInfo(jdbcTemplate, selectPageOrderQty, new String[]{ 
                requestParam.getPeriodId() + "%" }, pageParam);
    }

}
