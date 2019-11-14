package org.xiaoh.data.openapi.inventory.stock;

import java.text.ParseException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.constant.StockStatus;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;

/**
 * @Description: 商品库存更新基类
 * @author pengyc
 * @date 2019年11月4日 
 * @ClassName: AbstractStockUpdater
 */
public abstract class AbstractStockUpdater implements StockUpdater
{
    private Logger logger = LoggerFactory.getLogger(AbstractStockUpdater.class);
    
    /**
     * 商品库存DO对象
     */
    protected List<GoodsStockDO> goodsStockDOs;
    /**
     * 商品库存管理模块DAO组件
     */
    protected GoodsStockDAO goodsStockDAO;
    /**
     * 日期辅助组件
     */
    protected DateProvider dateProvider;

    /**
     * @param goodsStockDOs 
     * @param goodsStockDAO
     * @param dateProvider
     */
    public AbstractStockUpdater(List<GoodsStockDO> goodsStockDOs, GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider)
    {
        this.goodsStockDOs = goodsStockDOs;
        this.goodsStockDAO = goodsStockDAO;
        this.dateProvider = dateProvider;
    }

    /**
     * 更新商品库存
     */
    @Override
    public Boolean updateGoodsStock()
    {
        try 
        {
            updateSaleStockQuantity();
            updateLockedStockQuantity();
            updateSaledStockQuantity();
            updateStockStatus();
            updateGmtModified();
            executeUpdateGoodsStock();
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e);
            return false;  
        }
        return true;
    }
    
    /**
     * @Description: 更新销售库存
     */
    protected abstract void updateSaleStockQuantity();
    
    /**
     * @Description: 更新锁定库存
     */
    protected abstract void updateLockedStockQuantity();
    
    /**
     * @Description: 更新已销售库存
     */
    protected abstract void updateSaledStockQuantity();
    
    /**
     * @Description: 更新库存状态
     */
    protected void updateStockStatus()
    {
        for (GoodsStockDO goodsStockDO : goodsStockDOs)
        {
            if(goodsStockDO.getSaleStockQuantity() > 0)
            {
                goodsStockDO.setStockStatus(StockStatus.IN_STOCK);
            }
            else
            {
                goodsStockDO.setStockStatus(StockStatus.NOT_IN_STOCK); 
            }
        }
    }
    
    /**
     * @throws ParseException 
     * @Description: 更新商品库存更新时间
     */
    protected void updateGmtModified() throws ParseException
    {
        for (GoodsStockDO goodsStockDO : goodsStockDOs)
        {
            goodsStockDO.setGmtModified(dateProvider.getCurrentTime());
        }
    }
    
    /**
     * @throws Exception 
     * @Description: 执行实际更新商品库存的操作
     */
    protected void executeUpdateGoodsStock() throws Exception
    {
        for (GoodsStockDO goodsStockDO : goodsStockDOs)
        {
            goodsStockDAO.updateGoodsStock(goodsStockDO);
        }
    }
}
