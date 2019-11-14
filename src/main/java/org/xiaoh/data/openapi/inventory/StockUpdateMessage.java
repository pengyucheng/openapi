package org.xiaoh.data.openapi.inventory;

/**
 * @Description: 商品库存更新消息
 * @author pengyc
 * @date 2019年11月11日 
 * @ClassName: StockUpdateMessage
 *
 */
public class StockUpdateMessage
{
    /**
     * id
     */
    private String id;
    /**
     * 商品库存更新操作
     */
    private Integer operation;
    /**
     * 核心参数数据
     */
    private Object parameter;
    
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public Integer getOperation()
    {
        return operation;
    }
    public void setOperation(Integer operation)
    {
        this.operation = operation;
    }
    public Object getParameter()
    {
        return parameter;
    }
    public void setParameter(Object parameter)
    {
        this.parameter = parameter;
    }
}
