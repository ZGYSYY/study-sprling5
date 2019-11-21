package com.zgy.study.chapter04.subject02.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author ZGY <br>
 * @date 2019/11/21 16:39 <br>
 * @description Config <br>
 */
@Configuration
@ComponentScan(basePackages = "com.zgy.study.chapter04.subject02.demo01")
public class Config {

    @Lazy
    @Bean(initMethod = "init")
    public Singer singer() {
        Singer singer = new Singer();
        singer.setName("ZGY");
        singer.setAge(23);

        return singer;
    }

    @Lazy
    @Bean(initMethod = "init")
    public Singer singer2() {
        Singer singer = new Singer();
        singer.setAge(23);

        return singer;
    }

    @Lazy
    @Bean(initMethod = "init")
    public Singer singer3() {
        Singer singer = new Singer();

        return singer;
    }
}
