package org.xiaoh.data.openapi.wms.domain;

import java.util.Date;
import java.util.List;

/**
 * 
 * @Description: 采购入库单条目
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: PurchaseInputOrderItemDTO
 *
 */
public class PurchaseInputOrderItemDTO
{
    /**
     * 主键
     */
    private Long id;
    /**
     * 采购入库单id
     */
    private Long purchaseInputOrderId;
    /**
     * 商品skuid
     */
    private Long goodsSkuId;
    /**
     * 商品sku的采购数量
     */
    private Long purchaseCount;
    /**
     * 商品sku的采购架构
     */
    private Double purchasePrice;
    /**
     * 商品sku到货后质检出来的合格商品数量
     */
    private Long qualifiedCount;
    /**
     * 商品sku到货的数量
     */
    private Long arrivalCount;
    /**
     * 采购入库单条目的修改时间
     */
    private Date gmtCreate;
    /**
     * 采购入库单条目的修改时间
     */
    private Date gmtModified;
    /**
     * 采购入库单商品上架条目集合
     */
    private List<PurchaseInputOrderPutOnItemDTO> putOnItemDTOs;
    /**
     * 货拉库存明细
     */
    private List<GoodsAllocationStockDetailDTO> stockDetils;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getPurchaseInputOrderId()
    {
        return purchaseInputOrderId;
    }
    public void setPurchaseInputOrderId(Long purchaseInputOrderId)
    {
        this.purchaseInputOrderId = purchaseInputOrderId;
    }
    public Long getGoodsSkuId()
    {
        return goodsSkuId;
    }
    public void setGoodsSkuId(Long goodsSkuId)
    {
        this.goodsSkuId = goodsSkuId;
    }
    public Long getPurchaseCount()
    {
        return purchaseCount;
    }
    public void setPurchaseCount(Long purchaseCount)
    {
        this.purchaseCount = purchaseCount;
    }
    public Double getPurchasePrice()
    {
        return purchasePrice;
    }
    public void setPurchasePrice(Double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
    public Long getQualifiedCount()
    {
        return qualifiedCount;
    }
    public void setQualifiedCount(Long qualifiedCount)
    {
        this.qualifiedCount = qualifiedCount;
    }
    public Long getArrivalCount()
    {
        return arrivalCount;
    }
    public void setArrivalCount(Long arrivalCount)
    {
        this.arrivalCount = arrivalCount;
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
    public List<PurchaseInputOrderPutOnItemDTO> getPutOnItemDTOs()
    {
        return putOnItemDTOs;
    }
    public void setPutOnItemDTOs(List<PurchaseInputOrderPutOnItemDTO> putOnItemDTOs)
    {
        this.putOnItemDTOs = putOnItemDTOs;
    }
    public List<GoodsAllocationStockDetailDTO> getStockDetils()
    {
        return stockDetils;
    }
    public void setStockDetils(List<GoodsAllocationStockDetailDTO> stockDetils)
    {
        this.stockDetils = stockDetils;
    }
    @Override
    public String toString()
    {
        return "PurchaseInputOrderItemDTO [id=" + id + ", purchaseInputOrderId=" + purchaseInputOrderId
                + ", goodsSkuId=" + goodsSkuId + ", purchaseCount=" + purchaseCount + ", purchasePrice=" + purchasePrice
                + ", qualifiedCount=" + qualifiedCount + ", arrivalCount=" + arrivalCount + ", gmtCreate=" + gmtCreate
                + ", gmtModified=" + gmtModified + ", putOnItemDTOs=" + putOnItemDTOs + ", stockDetils=" + stockDetils
                + "]";
    }
    
}
