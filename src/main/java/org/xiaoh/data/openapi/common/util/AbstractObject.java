package org.xiaoh.data.openapi.common.util;

/**
 * 
 * @Description: 基础POJO类
 * @author pengyc
 * @date 2019年10月23日
 *
 */
public class AbstractObject
{
    /**
     * 浅度克隆
     * 
     * @param clazz
     * @return
     * @throws Exception
     */
    public <T> T clone(Class<T> clazz) throws Exception
    {
        T target = clazz.newInstance();
        BeanCopierUtil.copyProperties(this, target);
        return target;
    }

    /**
     * 浅度克隆
     * 
     * @param clazz
     * @return
     * @throws Exception
     */
    public <T> T clone(T target) throws Exception
    {
        BeanCopierUtil.copyProperties(this, target);
        return target;
    }

}
