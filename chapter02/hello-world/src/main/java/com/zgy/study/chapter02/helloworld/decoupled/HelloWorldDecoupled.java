package com.zgy.study.chapter02.helloworld.decoupled;

/**
 * @author ZGY <br>
 * @date 2019/11/19 12:10 <br>
 * @description HelloWorldDecoupled <br>
 */
public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer messageRenderer = new MessageRendererImpl();
        MessageProvider messageProvider = new MessageProviderImpl();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
