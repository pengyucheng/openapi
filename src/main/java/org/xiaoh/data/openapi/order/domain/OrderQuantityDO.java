package org.xiaoh.data.openapi.order.domain;

/**
 * 
 * @Description:OrderQuantity DO 
 * @author pengyc
 * @date 2019年8月29日 
 * @ClassName: OrderQuantityDO
 *
 */
public class OrderQuantityDO
{
    private String id;

    private String area;

    private String orgId;

    private String periodId;

    private Double billingQty;

    private String createDate;

    private String updateDate;

    private String loadDate;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getPeriodId()
    {
        return periodId;
    }

    public void setPeriodId(String periodId)
    {
        this.periodId = periodId;
    }

    public Double getBillingQty()
    {
        return billingQty;
    }

    public void setBillingQty(Double billingQty)
    {
        this.billingQty = billingQty;
    }

    public String getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(String updateDate)
    {
        this.updateDate = updateDate;
    }

    public String getLoadDate()
    {
        return loadDate;
    }

    public void setLoadDate(String loadDate)
    {
        this.loadDate = loadDate;
    }

    @Override
    public String toString()
    {
        return "OrderQuantityDO [id=" + id + ", area=" + area + ", orgId=" + orgId + ", periodId=" + periodId
                + ", billingQty=" + billingQty + ", createDate=" + createDate + ", updateDate=" + updateDate
                + ", loadDate=" + loadDate + "]";
    }

}
