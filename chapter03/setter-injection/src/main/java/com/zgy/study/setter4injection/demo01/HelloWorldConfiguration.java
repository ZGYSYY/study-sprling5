package com.zgy.study.setter4injection.demo01;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;
import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 20:27 <br>
 * @description: HelloWorldConfiguration <br>
 * @version: 1.0 <br>
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public MessageProvider messageProvider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        StandardOutMessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
