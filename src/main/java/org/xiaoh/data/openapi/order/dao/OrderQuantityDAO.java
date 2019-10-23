package org.xiaoh.data.openapi.order.dao;

import org.xiaoh.data.openapi.order.domain.OrderQuantityQuery;
import org.xiaoh.data.openapi.order.domain.PageInfo;

/**
 * 
 * @Description: OrderQuantity DAO 层接口
 * @author pengyc
 * @date 2019年8月26日 
 * @ClassName: OrderQuantityDAO
 *
 */
public interface OrderQuantityDAO
{
    /**
     * 
     * @Description: selectPage
     * @param requestParam
     * @return Pagination<OrderQuantityDO> OrderQuantityDO 分页信息
     */
	PageInfo selectPage(OrderQuantityQuery requestParam);
}
