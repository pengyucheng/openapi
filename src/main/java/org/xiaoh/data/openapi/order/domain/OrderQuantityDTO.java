package org.xiaoh.data.openapi.order.domain;

/**
 * 
 * @Description: 订单数量实体DTO
 * @author pengyc
 * @date 2019年8月26日
 * @ClassName: OrderQuantityDTO
 *
 */
public class OrderQuantityDTO
{
    private String area;

    private String org_id;

    private String period_id;

    private Double billing_qty;

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getOrg_id()
    {
        return org_id;
    }

    public void setOrg_id(String org_id)
    {
        this.org_id = org_id;
    }

    public String getPeriod_id()
    {
        return period_id;
    }

    public void setPeriod_id(String period_id)
    {
        this.period_id = period_id;
    }

    public Double getBilling_qty()
    {
        return billing_qty;
    }

    public void setBilling_qty(Double billing_qty)
    {
        this.billing_qty = billing_qty;
    }

}
