package com.zgy.study.chapter04.subject04.demo01;

import com.sun.javafx.runtime.SystemProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZGY <br>
 * @date 2019/11/21 17:33 <br>
 * @description Config <br>
 */
@Configuration
@ComponentScan(basePackages = "com.zgy.study.chapter04.subject04.demo01")
public class Config {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DestructiveBean destructiveBean() {
        DestructiveBean destructiveBean = new DestructiveBean();
        destructiveBean.setFilePath(SystemProperties.getProperty("java.io.tmpdir") + SystemProperties.getProperty("file.separator") + "test.txt.txt");

        return destructiveBean;
    }
}
