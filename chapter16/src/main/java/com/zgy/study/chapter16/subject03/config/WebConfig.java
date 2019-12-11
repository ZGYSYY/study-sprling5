package com.zgy.study.chapter16.subject03.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author ZGY
 * @date 2019/12/11 15:49
 * @description WebConfig
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zgy.study.chapter16.subject03")
public class WebConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("=============> 执行了 public void addResourceHandlers(ResourceHandlerRegistry registry) 方法");
        registry.addResourceHandler("/resources/**").addResourceLocations("/").setCachePeriod(31557926);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        LOGGER.info("=============> 执行了 public void addViewControllers(ViewControllerRegistry registry) 方法");
        registry.addViewController("/v1").setViewName("singers/index");
        registry.addRedirectViewController("/v2", "/singers");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        LOGGER.info("=============> 执行了 public InternalResourceViewResolver viewResolver() 方法");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jspx");
        resolver.setRequestContextAttribute("requestContext");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        LOGGER.info("=============> 执行了 public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) 方法");
        configurer.enable();
    }
}
