package com.zgy.study.chapter02.helloworld;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/19 14:14 <br>
 * @description HelloWorldSpringDI <br>
 */
public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
        MessageRenderer renderer = applicationContext.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
