package org.xiaoh.data.openapi.domain;

/**
 * 
 * @Description: 订单开票请求参数封装类
 * @author pengyc
 * @date 2019年8月27日
 * @ClassName: OrderQuantityQuery
 *
 */
public class OrderQuantityQuery extends CommonReqParam
{
    /**
     * 订单日期
     */
    private String periodId;

    public String getPeriodId()
    {
        return periodId;
    }

    public void setPeriodId(String periodId)
    {
        this.periodId = periodId;
    }

    @Override
    public String toString()
    {
        return "OrderQuantityQuery [periodId=" + periodId + ", pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
    }

}
