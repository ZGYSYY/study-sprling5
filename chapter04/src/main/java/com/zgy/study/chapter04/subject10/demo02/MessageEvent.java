package com.zgy.study.chapter04.subject10.demo02;

import org.springframework.context.ApplicationEvent;

/**
 * @author ZGY <br>
 * @date 2019/11/25 14:17 <br>
 * @description MessageEvent <br>
 */
public class MessageEvent extends ApplicationEvent {

    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
