package org.xiaoh.data.openapi.util;

import java.util.regex.Pattern;

/**
 * 
 * @Description: String Utils
 * @author pengyc
 * @date 2019年8月26日
 * @ClassName: StringUtils
 *
 */
public class StringUtils
{
    /**
     * 判断一个字符串是否是数字。
     * 
     * @param string
     * @return true or false
     */
    public static boolean isNumber(String string)
    {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }

}
