package com.zgy.study.setter4injection.demo02;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;
import org.springframework.stereotype.Component;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 19:53 <br>
 * @description: HelloWorldMessageProvider <br>
 * @version: 1.0 <br>
 */
@Component("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
