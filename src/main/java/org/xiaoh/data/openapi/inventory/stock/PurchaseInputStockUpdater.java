package org.xiaoh.data.openapi.inventory.stock;

import java.util.List;
import java.util.Map;
import org.xiaoh.data.openapi.common.util.DateProvider;
import org.xiaoh.data.openapi.inventory.dao.GoodsStockDAO;
import org.xiaoh.data.openapi.inventory.domain.GoodsStockDO;
import org.xiaoh.data.openapi.wms.domain.PurchaseInputOrderItemDTO;

/**
 * @Description: 采购入库库存更新命令
 * @author pengyc
 * @date 2019年11月5日 
 * @ClassName: PurchaseInputStockUpdater
 *
 */
public class PurchaseInputStockUpdater extends AbstractStockUpdater
{
    /**
     * key:skuid value: PurchaseInputOrderItemDTO
     */
    private Map<Long, PurchaseInputOrderItemDTO> skuId2PIItemDTO ;
    
    public PurchaseInputStockUpdater(List<GoodsStockDO> goodsStockDOs, GoodsStockDAO goodsStockDAO,
            DateProvider dateProvider, Map<Long, PurchaseInputOrderItemDTO> skuId2PIItemDTO)
    {
        super(goodsStockDOs, goodsStockDAO, dateProvider);
        this.skuId2PIItemDTO = skuId2PIItemDTO;
    }

    /**
     * 更新销售库存
     */
    @Override
    protected void updateSaleStockQuantity()
    {
        for (GoodsStockDO goodsStockDO : goodsStockDOs)
        {
            Long arrivalCount = skuId2PIItemDTO.get(goodsStockDO.getGoodsSkuId()).getArrivalCount();
            goodsStockDO.setSaleStockQuantity(goodsStockDO.getSaleStockQuantity() + arrivalCount);
        }
    }

    @Override
    protected void updateLockedStockQuantity()
    {
    }

    @Override
    protected void updateSaledStockQuantity()
    {
    }

}
