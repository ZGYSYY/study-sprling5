package com.zgy.study.chapter04.subject06.demo02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZGY <br>
 * @date 2019/11/22 11:26 <br>
 * @description App <br>
 */

@Configuration
@ComponentScan(basePackages = "com.zgy.study.chapter04.subject06.demo02")
public class App {

    @Bean
    public MessageDigestFactoryBean shaMessageDigestFactoryBean() {
        MessageDigestFactoryBean messageDigestFactoryBean = new MessageDigestFactoryBean();
        messageDigestFactoryBean.setAlgorithmName("SHA1");

        return messageDigestFactoryBean;
    }

    @Bean
    public MessageDigestFactoryBean defaultMessageDigestFactoryBean() {
        MessageDigestFactoryBean messageDigestFactoryBean = new MessageDigestFactoryBean();

        return messageDigestFactoryBean;
    }

    @Bean
    public MessageDigester messageDigester() throws Exception {
        MessageDigester messageDigester = new MessageDigester();
        messageDigester.setMessageDigest(shaMessageDigestFactoryBean().getObject());
        messageDigester.setMessageDigest2(defaultMessageDigestFactoryBean().getObject());

        return messageDigester;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        MessageDigester messageDigester = context.getBean("messageDigester", MessageDigester.class);
        messageDigester.digest("好好学习，天天向上！");

        context.close();
    }
}
