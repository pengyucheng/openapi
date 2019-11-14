package org.xiaoh.data.openapi.inventory.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.xiaoh.data.openapi.inventory.domain.StockUpdateMessageDO;

/**
 * @Description: 库存更新消息mapper组件接口
 * @author pengyc
 * @date 2019年11月12日 
 * @ClassName: StockUpdateMessageMapper
 *
 */
@Mapper
public interface StockUpdateMessageMapper
{
    @Insert("INSERT INTO inventory_offline_stock_update_message("
                + " message_id,"
                + " operation,"
                + " parameter,"
                + " parameter_clazz,"
                + " gmt_create,"
                + " gmt_modified"
            + ") VALUES("
                + "#{messageId},"
                + "#{operation},"
                + "#{parameter},"
                + "#{parameterClazz},"
                + "#{gmtCreate},"
                + "#{gmtModified}"
            + ") ")
    void save(StockUpdateMessageDO stockUpdateMessageDO);
    
    /**
     * @Description: 批量查询库存更新消息：每次50条
     * @return 
     */
    @Select("SELECT "
                + "id, "
                + "message_id,"
                + "operation,"
                + "parameter,"
                + "parameter_clazz,"
                + "gmt_create,"
                + "gmt_modified "
            + " FROM inventory_offline_stock_update_message "
            + " ORDER BY id"
            + " LIMIT 50 ")
    @Results({
        @Result(column = "id", property = "id", id = true),
        @Result(column = "message_id", property = "messageId"),
        @Result(column = "operation", property = "operation"),
        @Result(column = "parameter", property = "paramter"),
        @Result(column = "parameter_clazz", property = "parameterClazz"),
        @Result(column = "gmt_create", property = "gmtCreate"),
        @Result(column = "gmt_modified", property = "gmtModified"),
    })
    List<StockUpdateMessageDO> listByBatch();
    
    /**
     * @Description: 查询库存更新消息记录数
     * @return 库存更新消息记录数
     */
    @Select("SELECT count(*) FROM inventory_offline_stock_update_message ")
    Long count();
    
    /**
     * @Description: 批量删除库存更新消息
     * @param messageIds
     */
    @Delete("DELETE FROM inventory_offline_stock_update_message WHERE message_id IN (${messageIds}) ")
    void removeByBatch(@Param("messageId") String messageIds);
}
