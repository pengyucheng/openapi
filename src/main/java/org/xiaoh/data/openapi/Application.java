package org.xiaoh.data.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.xiaoh.data.openapi.common.config.DruidDataSourceConfig;

/**
 * 
 * @Description: 系统启动类
 * @author pengyc
 * @date 2019年8月23日
 * @ClassName: Application
 *
 */
@SpringBootApplication
@ServletComponentScan
@Import(DruidDataSourceConfig.class)
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

}
