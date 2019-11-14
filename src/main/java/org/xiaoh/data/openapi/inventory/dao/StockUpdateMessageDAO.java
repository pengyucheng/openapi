package org.xiaoh.data.openapi.inventory.dao;

import java.util.List;

import org.xiaoh.data.openapi.inventory.domain.StockUpdateMessageDO;

/**
 * @Description: 库存更新消息DAO组件
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateMessageDAO
 *
 */
public interface StockUpdateMessageDAO
{
    /**
     * @Description: 新增库存更新消息
     * @param stockUpdateMessageDO
     * @throws Exception
     */
    void save(StockUpdateMessageDO stockUpdateMessageDO) throws Exception;

    /**
     * @Description: 批量查询库存更新消息：每次50条
     * @return
     * @throws Exception
     */
    List<StockUpdateMessageDO> listByBatch() throws Exception;
    
    /**
     * @Description: 批量删除库存更新消息
     * @param ids
     * @throws Exception
     */
    void removeByBatch(String ids) throws Exception;
    
    /**
     * @Description: 查询库存更新消息记录数
     * @return 库存更新消息记录数
     * @throws Exception
     */
    Long count() throws Exception;
}
