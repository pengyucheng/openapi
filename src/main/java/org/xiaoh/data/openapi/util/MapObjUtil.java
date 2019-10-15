package org.xiaoh.data.openapi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * 
 * @Description: Map与Object转换帮助类
 * @author pengyc
 * @date 2019年8月26日
 * @ClassName: Map2ObjUtil
 *
 */
public class MapObjUtil
{

    /**
     * 
     * @Description: map2obj2
     * @param map
     * @param clazz
     * @return 转换后的 Object
     * @throws Exception
     */
    public static Object map2obj2(Map<String, Object> map, Class<?> clazz) throws Exception
    {
        Object obj = clazz.newInstance();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields)
        {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod))
            {
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
            
            // field = orgId ; field.getName() = org_id  
        }

        return obj;
    }
    
    
}
