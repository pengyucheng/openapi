package org.xiaoh.data.openapi.domain;

public class OrderQtyDTO
{
    private String area;

    private String orgId;

    private String periodId;

    private Double billingQty;

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
    
}
