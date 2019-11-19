package com.zgy.study.chapter02.helloworld.decoupled;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ZGY <br>
 * @date 2019/11/19 13:48 <br>
 * @description MessageSupportFactory <br>
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties properties;

    private MessageRenderer messageRenderer;

    private MessageProvider messageProvider;

    private MessageSupportFactory() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/msf.properties"));
            String rendererClass = properties.getProperty("renderer.class");
            String providerClass = properties.getProperty("provider.class");

            this.messageRenderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            this.messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
