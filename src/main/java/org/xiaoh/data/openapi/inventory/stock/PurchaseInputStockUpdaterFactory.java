package org.xiaoh.data.openapi.inventory.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;
import org.xiaoh.data.openapi.wms.domain.PurchaseInputOrderDTO;
import org.xiaoh.data.openapi.wms.domain.PurchaseInputOrderItemDTO;

/**
 * @Description: 采购入库库存更新命令生产工厂
 * @author pengyc
 * @date 2019年11月5日
 * @ClassName: PurchaseInputStockUpdaterFactory
 *
 */
@Component
public class PurchaseInputStockUpdaterFactory extends AbstractStockUpdaterFactory<PurchaseInputOrderDTO>
{
    /**
     * Description: 构造器
     * @param goodsStockDAO
     * @param dateProvider
     */
    @Autowired
    public PurchaseInputStockUpdaterFactory(GoodsStockDAO goodsStockDAO, DateProvider dateProvider)
    {
        super(goodsStockDAO, dateProvider);
    }

    /**
     * 构造函数
     * @param goodStockDOs 库存 DO
     * @param paramter 请求参数
     */
    @Override
    protected StockUpdater create(List<GoodsStockDO> goodStockDOs, PurchaseInputOrderDTO paramter) throws Exception
    {
        Map<Long, PurchaseInputOrderItemDTO> skuId2PIItemDTO = 
                new HashMap<Long, PurchaseInputOrderItemDTO>(16);
        PurchaseInputOrderDTO pioDTO = paramter;
        List<PurchaseInputOrderItemDTO> pioItemDTOs = pioDTO.getItems();
        if(null != pioItemDTOs)
        {
            for (PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : pioItemDTOs)
            {
                skuId2PIItemDTO.put(purchaseInputOrderItemDTO.getGoodsSkuId(), 
                        purchaseInputOrderItemDTO);
            }
        }
        return new PurchaseInputStockUpdater(goodStockDOs, goodsStockDAO, dateProvider, skuId2PIItemDTO);
    }

    /**
     * 获取商品 sku id
     */
    @Override
    protected List<Long> getGoodSkuId(PurchaseInputOrderDTO paramter) throws Exception
    {
        List<Long> goodSkuIds = new ArrayList<Long>();
        PurchaseInputOrderDTO pioDTO = paramter;
        List<PurchaseInputOrderItemDTO> pioItemDTOs = pioDTO.getItems();
        if (null != pioItemDTOs)
        {
            for (PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : pioItemDTOs)
            {
                goodSkuIds.add(purchaseInputOrderItemDTO.getGoodsSkuId());
            }
        }
        return goodSkuIds;
    }
}
