package com.zgy.study.chapter17.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
# 知识点
@EnableWebMvc：告诉 Spring 在使用 SpringMVC模块时不使用 XML 文件配置，而是用 JavaConfig 进行配置。
 */

/**
 * @author ZGY <br/>
 * @date 2019/12/10 17:10 <br/>
 * @description WebConfig <br/>
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * 相当于 <mvc:default-servlet-handler/> 标签的作用。
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 相当于 <mvc:view-controller/> 标签的作用。
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/static/index.html");
    }
}
