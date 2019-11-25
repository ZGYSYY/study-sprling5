package com.zgy.study.chapter04.subject12.demo03;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:19 <br>
 * @description StandardOutMessageRenderer <br>
 */
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
        System.out.println(" --> StandardOutMessageRenderer: constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class: " + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        System.out.println("--> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
