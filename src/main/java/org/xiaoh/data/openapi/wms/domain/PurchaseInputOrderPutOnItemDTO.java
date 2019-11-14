package org.xiaoh.data.openapi.wms.domain;

import java.util.Date;

/**
 * @Description: 采购入库单的商品上架条目
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: PurchaseInputOrderPutOnItemDTO
 *
 */
public class PurchaseInputOrderPutOnItemDTO
{
    /**
     * 主键
     */
    private Long id;
    /**
     * 采购入库单条目id
     */
    private Long purchaseInputOrderItemId;
    /**
     * 货位id
     */
    private Long goodsAllocationId;
    /**
     * 商品sku id
     */
    private Long goodsSkuId;
    /**
     * 商品上架数量
     */
    private Long putOnShelvesCount;
    /**
     * 商品上架条目的创建时间
     */
    private Date gmtCreate;
    /**
     * 商品上架条目的修改时间
     */
    private Date gmtModified;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getPurchaseInputOrderItemId()
    {
        return purchaseInputOrderItemId;
    }
    public void setPurchaseInputOrderItemId(Long purchaseInputOrderItemId)
    {
        this.purchaseInputOrderItemId = purchaseInputOrderItemId;
    }
    public Long getGoodsAllocationId()
    {
        return goodsAllocationId;
    }
    public void setGoodsAllocationId(Long goodsAllocationId)
    {
        this.goodsAllocationId = goodsAllocationId;
    }
    public Long getGoodsSkuId()
    {
        return goodsSkuId;
    }
    public void setGoodsSkuId(Long goodsSkuId)
    {
        this.goodsSkuId = goodsSkuId;
    }
    public Long getPutOnShelvesCount()
    {
        return putOnShelvesCount;
    }
    public void setPutOnShelvesCount(Long putOnShelvesCount)
    {
        this.putOnShelvesCount = putOnShelvesCount;
    }
    public Date getGmtCreate()
    {
        return gmtCreate;
    }
    public void setGmtCreate(Date gmtCreate)
    {
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtModified()
    {
        return gmtModified;
    }
    public void setGmtModified(Date gmtModified)
    {
        this.gmtModified = gmtModified;
    }
    @Override
    public String toString()
    {
        return "PurchaseInputOrderPutOnItemDTO [id=" + id + ", purchaseInputOrderItemId=" + purchaseInputOrderItemId
                + ", goodsAllocationId=" + goodsAllocationId + ", goodsSkuId=" + goodsSkuId + ", putOnShelvesCount="
                + putOnShelvesCount + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
    
}
