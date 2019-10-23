package org.xiaoh.data.openapi.common.util;

import java.text.ParseException;
import java.util.Date;

/**
 * 
 * @Description: 日期辅助组件接口
 * @author pengyc
 * @date 2019年10月22日 
 *
 */
public interface DateProvider
{
    /**
     * 
     * @Description: getCurrentTime
     * @return 系统当前时间
     * @throws ParseException
     */
    Date getCurrentTime() throws ParseException;
    
    /**
     * 
     * @Description: 将日期串转换成日期对象
     * @param date
     * @return 日期对象
     * @throws Exception
     */
    Date parseDatetime(String date) throws Exception;
    
    /**
     * 
     * @Description: 将日期对象格式化成 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return 格式化后的日期串
     * @throws Exception
     */
    String formatDatetime(Date date) throws Exception;
}
