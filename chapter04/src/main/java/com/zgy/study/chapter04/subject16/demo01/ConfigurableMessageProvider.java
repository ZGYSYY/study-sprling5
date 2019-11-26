package com.zgy.study.chapter04.subject16.demo01;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:16 <br>
 * @description ConfigurableMessageProvider <br>
 */
@Named("messageProvider")
@Singleton
public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
