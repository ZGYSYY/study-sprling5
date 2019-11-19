package com.zgy.study.chapter02.helloworld.annotated;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/19 14:36 <br>
 * @description HelloWorldSpringAnnotated <br>
 */
public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
