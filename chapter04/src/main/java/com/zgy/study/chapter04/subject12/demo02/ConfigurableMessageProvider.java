package com.zgy.study.chapter04.subject12.demo02;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:16 <br>
 * @description ConfigurableMessageProvider <br>
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

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
