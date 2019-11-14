package org.xiaoh.data.openapi.inventory.stock;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.constant.StockStatus;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;

/**
 * @Description: 库存更新工厂基类
 * @author pengyc
 * @date 2019年11月5日 
 * @ClassName: AbstractStockUpdaterFactory
 *
 */
public abstract class AbstractStockUpdaterFactory<T> implements StockUpdaterFactory<T>
{
    private Logger logger = LoggerFactory.getLogger(AbstractStockUpdater.class);
    
    /**
     * 商品库存 DAO 组件
     */
    protected GoodsStockDAO goodsStockDAO;
    
    /**
     * 日期辅助组件
     */
    protected DateProvider dateProvider;
    
    /**
     * <p>Description: 构造器
     * @param goodsStockDAO
     * @param dateProvider
     */
    public AbstractStockUpdaterFactory(GoodsStockDAO goodsStockDAO, DateProvider dateProvider)
    {
        this.goodsStockDAO = goodsStockDAO;
        this.dateProvider = dateProvider;
    }

    /**
     * @Description: 创建 StockUpdater
     * @param paramter
     * @return
     * @throws Exception 
     */
    @Override
    public StockUpdater create(T paramter)
    {
        try
        {
            List<Long> goodSkuIds = getGoodSkuId(paramter);
            List<GoodsStockDO> goodStockDOs = createGoodStockDO(goodSkuIds);
            return create(goodStockDOs, paramter); 
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e);
            return null;
        }
    }
    
    /**
     * @Description: 创建库存更新命令
     * @param goodStockDOs
     * @param paramter
     * @return StockUpdater
     * @throws Exception 
     */
    protected abstract StockUpdater create(List<GoodsStockDO> goodStockDOs, T paramter) throws Exception;

    /**
     * @Description: 获取商品Sku Id
     * @param paramter
     * @return
     * @throws Exception 
     */
    protected abstract List<Long> getGoodSkuId(T paramter) throws Exception;
    
    /**
     * @Description: 创建 GoodStockDO集
     * @param goodSkuIds
     * @return
     * @throws Exception 
     */
    private List<GoodsStockDO> createGoodStockDO(List<Long> goodSkuIds) throws Exception
    {
        List<GoodsStockDO> goodStockDOs = new ArrayList<GoodsStockDO>(goodSkuIds.size());
        for (Long goodSkuId : goodSkuIds)
        {
            GoodsStockDO goodsStockDO = goodsStockDAO.getGoodsStockBySkuId(goodSkuId);
            if(null == goodsStockDO)
            {
                goodsStockDO = createGoodStock(goodSkuId);
            }
            goodStockDOs.add(goodsStockDO);
        }
        return goodStockDOs;
    }

    /**
     * @Description: 创建 GoodStockDO 对象
     * @param goodSkuId
     * @return 
     * @throws ParseException 
     */
    private GoodsStockDO createGoodStock(Long goodSkuId) throws ParseException
    {
        GoodsStockDO goodsStockDO = new GoodsStockDO();
        goodsStockDO.setGoodsSkuId(goodSkuId);
        goodsStockDO.setSaleStockQuantity(0L);
        goodsStockDO.setLockedStockQuantity(0L); 
        goodsStockDO.setSaledStockQuantity(0L);
        goodsStockDO.setStockStatus(StockStatus.NOT_IN_STOCK); 
        goodsStockDO.setGmtCreate(dateProvider.getCurrentTime());
        goodsStockDO.setGmtModified(dateProvider.getCurrentTime());  
        return goodsStockDO;
    }
}
