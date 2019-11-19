package com.zgy.study.setter4injection.demo06;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;
import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 19:55 <br>
 * @description: StandardOutMessageRenderer <br>
 * @version: 1.0 <br>
 */
@Component
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("messageProvider 为空：" + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return null;
    }
}
