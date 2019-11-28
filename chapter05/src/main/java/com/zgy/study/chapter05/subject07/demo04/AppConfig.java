package com.zgy.study.chapter05.subject07.demo04;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZGY <br>
 * @date 2019/11/28 10:00 <br>
 * @description AppConfig <br>
 */
@Configuration
public class AppConfig {

    @Bean
    public Contact contact() {
        Contact contact = new Contact();
        contact.setName("ZGY");

        return contact;
    }

    @Bean("advisor")
    public IsModifiedAdvisor isModifiedAdvisor() {
        IsModifiedAdvisor advisor = new IsModifiedAdvisor();

        return advisor;
    }

    @Bean("proxy")
    public ProxyFactoryBean proxyFactoryBean() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.addAdvisor(isModifiedAdvisor());
        proxyFactoryBean.setTarget(contact());
        proxyFactoryBean.setProxyTargetClass(true);

        return proxyFactoryBean;
    }
}
