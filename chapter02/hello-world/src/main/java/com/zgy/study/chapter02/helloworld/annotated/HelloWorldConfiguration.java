package com.zgy.study.chapter02.helloworld.annotated;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;
import com.zgy.study.chapter02.helloworld.decoupled.MessageProviderImpl;
import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import com.zgy.study.chapter02.helloworld.decoupled.MessageRendererImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZGY <br>
 * @date 2019/11/19 14:33 <br>
 * @description HelloWorldConfiguration <br>
 */
@Configuration
public class HelloWorldConfiguration {

    public MessageProvider messageProvider() {
        return new MessageProviderImpl();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        MessageRenderer messageRenderer = new MessageRendererImpl();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
