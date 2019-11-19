package com.zgy.study.setter4injection.demo01;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 19:53 <br>
 * @description: HelloWorldMessageProvider <br>
 * @version: 1.0 <br>
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
