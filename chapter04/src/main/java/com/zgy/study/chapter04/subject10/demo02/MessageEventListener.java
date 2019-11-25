package com.zgy.study.chapter04.subject10.demo02;

import org.springframework.context.ApplicationListener;

/**
 * @author ZGY <br>
 * @date 2019/11/25 14:19 <br>
 * @description MessageEventListener <br>
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent messageEvent = event;
        System.out.println("Received: " + messageEvent.getMsg());
    }
}
