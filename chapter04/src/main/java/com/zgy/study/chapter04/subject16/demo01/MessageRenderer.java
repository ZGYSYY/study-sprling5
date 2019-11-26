package com.zgy.study.chapter04.subject16.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:18 <br>
 * @description MessageRenderer <br>
 */
public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
