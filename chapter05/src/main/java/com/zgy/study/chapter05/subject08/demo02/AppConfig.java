package com.zgy.study.chapter05.subject08.demo02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ZGY <br>
 * @date 2019/11/28 14:45 <br>
 * @description AppConfig <br>
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.zgy.study.chapter05.subject08.demo02")
public class AppConfig {
}
