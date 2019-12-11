package com.zgy.study.chapter16.subject03.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author ZGY
 * @date 2019/12/11 15:28
 * @description 在 Spring3.1 后，继承 AbstractAnnotationConfigDispatcherServletInitializer 并重写对应方法就能代替以前的 web.xml 文件。
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
