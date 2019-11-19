package com.zgy.study.setter4injection;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import com.zgy.study.setter4injection.demo03.HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 20:50 <br>
 * @description: Demo03Application <br>
 * @version: 1.0 <br>
 */
public class Demo03Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
