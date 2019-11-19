package com.zgy.study.chapter02.helloworld.decoupled;

/**
 * @author ZGY <br>
 * @date 2019/11/19 14:00 <br>
 * @description HelloWorldDecoupledWithFactory <br>
 */
public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageSupportFactory instance = MessageSupportFactory.getInstance();
        MessageProvider messageProvider = instance.getMessageProvider();
        MessageRenderer messageRenderer = instance.getMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
