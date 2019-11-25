package com.zgy.study.chapter04.subject12.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:29 <br>
 * @description Config <br>
 */
@Configuration
@ComponentScan(basePackages = "com.zgy.study.chapter04.subject12.demo02")
public class Config {

    @Bean
    public MessageProvider messageProvider() {
        MessageProvider messageProvider = new ConfigurableMessageProvider("好好学习，天天向上");

        return messageProvider;
    }

    @Bean
    public MessageRenderer messageRenderer() {
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
