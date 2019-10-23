package org.xiaoh.data.openapi.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description: 日期辅助组件实现类
 * @author pengyc
 * @date 2019年10月22日 
 *
 */
@Component
public class DateProviderImpl implements DateProvider
{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * 获取系统当前时间
     * @throws ParseException 
     */
    @Override
    public Date getCurrentTime() throws ParseException
    {
        return sdf.parse(sdf.format(new Date()));
    }

    /**
     * 
     * @Description: 将日期串转换成日期对象
     * @param date
     * @return 日期对象
     * @throws Exception
     */
    @Override
    public Date parseDatetime(String date) throws Exception
    {
        return sdf.parse(date);
    }

    /**
     * 
     * @Description: 将日期对象格式化成 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return 格式化后的日期串
     * @throws Exception
     */
    @Override
    public String formatDatetime(Date date) throws Exception
    {
        return sdf.format(date);
    }

}
