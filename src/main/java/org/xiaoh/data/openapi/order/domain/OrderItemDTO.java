package org.xiaoh.data.openapi.order.domain;

import java.util.Date;

/**
 * @Description: 订单条目DTO类
 * @author pengyc
 * @date 2019年11月5日 
 * @ClassName: OrderItemDTO
 *
 */
public class OrderItemDTO
{
    /**
     * id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderInfoId;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品skuid
     */
    private Long goodsSkuId;
    /**
     * 商品sku编码
     */
    private String goodsSkuCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品的销售属性
     */
    private String saleProperties;
    /**
     * 商品毛重
     */
    private Double goodsGrossWeight;
    /**
     * 商品sku的购买数量
     */
    private Long purchaseQuantity;
    /**
     * 商品sku使用的促销活动id
     */
    private Long promotionActivityId;
    /**
     * 商品长度
     */
    private Double goodsLenght;
    /**
     * 商品宽度
     */
    private Double goodsWidth;
    /**
     * 商品高度
     */
    private Double goodsHeight;
    /**
     * 购买价格
     */
    private Double purchasePrice;
    /**
     * 订单条目的创建时间
     */
    private Date gmtCreate;
    /**
     * 订单条目的修改时间
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
    public Long getOrderInfoId()
    {
        return orderInfoId;
    }
    public void setOrderInfoId(Long orderInfoId)
    {
        this.orderInfoId = orderInfoId;
    }
    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }
    public Long getGoodsSkuId()
    {
        return goodsSkuId;
    }
    public void setGoodsSkuId(Long goodsSkuId)
    {
        this.goodsSkuId = goodsSkuId;
    }
    public String getGoodsSkuCode()
    {
        return goodsSkuCode;
    }
    public void setGoodsSkuCode(String goodsSkuCode)
    {
        this.goodsSkuCode = goodsSkuCode;
    }
    public String getGoodsName()
    {
        return goodsName;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }
    public String getSaleProperties()
    {
        return saleProperties;
    }
    public void setSaleProperties(String saleProperties)
    {
        this.saleProperties = saleProperties;
    }
    public Double getGoodsGrossWeight()
    {
        return goodsGrossWeight;
    }
    public void setGoodsGrossWeight(Double goodsGrossWeight)
    {
        this.goodsGrossWeight = goodsGrossWeight;
    }
    public Long getPurchaseQuantity()
    {
        return purchaseQuantity;
    }
    public void setPurchaseQuantity(Long purchaseQuantity)
    {
        this.purchaseQuantity = purchaseQuantity;
    }
    public Long getPromotionActivityId()
    {
        return promotionActivityId;
    }
    public void setPromotionActivityId(Long promotionActivityId)
    {
        this.promotionActivityId = promotionActivityId;
    }
    public Double getGoodsLenght()
    {
        return goodsLenght;
    }
    public void setGoodsLenght(Double goodsLenght)
    {
        this.goodsLenght = goodsLenght;
    }
    public Double getGoodsWidth()
    {
        return goodsWidth;
    }
    public void setGoodsWidth(Double goodsWidth)
    {
        this.goodsWidth = goodsWidth;
    }
    public Double getGoodsHeight()
    {
        return goodsHeight;
    }
    public void setGoodsHeight(Double goodsHeight)
    {
        this.goodsHeight = goodsHeight;
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
    public Double getPurchasePrice()
    {
        return purchasePrice;
    }
    public void setPurchasePrice(Double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
    @Override
    public String toString()
    {
        return "OrderItemDTO [id=" + id + ", orderInfoId=" + orderInfoId + ", goodsId=" + goodsId + ", goodsSkuId="
                + goodsSkuId + ", goodsSkuCode=" + goodsSkuCode + ", goodsName=" + goodsName + ", saleProperties="
                + saleProperties + ", goodsGrossWeight=" + goodsGrossWeight + ", purchaseQuantity=" + purchaseQuantity
                + ", promotionActivityId=" + promotionActivityId + ", goodsLenght=" + goodsLenght + ", goodsWidth="
                + goodsWidth + ", goodsHeight=" + goodsHeight + ", gmtCreate=" + gmtCreate + ", gmtModified="
                + gmtModified + "]";
    }
    
}
