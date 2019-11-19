package com.zgy.study.setter4injection.demo08;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:11 <br>
 * @description: ConfigurableMessageProvider <br>
 * @version: 1.0 <br>
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
