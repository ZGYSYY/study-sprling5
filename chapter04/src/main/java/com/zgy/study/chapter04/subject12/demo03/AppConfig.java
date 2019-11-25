package com.zgy.study.chapter04.subject12.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:34 <br>
 * @description AppConfig <br>
 */
@Configuration
@PropertySource("classpath:subject12/demo03/message.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(environment.getProperty("message"));
    }

    @Bean
    public MessageRenderer messageRenderer() {
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
