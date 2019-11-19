package com.zgy.study.setter4injection;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import com.zgy.study.setter4injection.demo02.HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 20:38 <br>
 * @description: Demo02Application <br>
 * @version: 1.0 <br>
 */
public class Demo02Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
