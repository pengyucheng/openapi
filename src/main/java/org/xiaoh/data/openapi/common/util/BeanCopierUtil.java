package org.xiaoh.data.openapi.common.util;

import java.util.HashMap;
import java.util.Map;
import net.sf.cglib.beans.BeanCopier;

/**
 * 
 * @Description: Bean Copier 工具类
 * @author pengyc
 * @date 2019年10月21日 
 *
 */
public class BeanCopierUtil
{
    private static Map<String, BeanCopier> beanCopierCache = new HashMap<>(16);
    
    public static BeanCopier getBeanCopier(Object source, Object target)
    {
        String key = source.getClass().getName() + target.getClass().getName();
        
        if(!beanCopierCache.containsKey(key))
        {
            synchronized(BeanCopierUtil.class)
            {
                if(!beanCopierCache.containsKey(key))
                {
                    BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false); 
                    beanCopierCache.put(key, beanCopier);
                }
            }
        }
        
        return beanCopierCache.get(key);
    }
    
    public static void copyProperties(Object source, Object target)
    {
        getBeanCopier(source, target).copy(source, target, null);
    }
}
