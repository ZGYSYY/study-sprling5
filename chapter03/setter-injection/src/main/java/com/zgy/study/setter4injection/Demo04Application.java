package com.zgy.study.setter4injection;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 20:57 <br>
 * @description: Demo04Application <br>
 * @version: 1.0 <br>
 */
public class Demo04Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo04-app-context.xml");
        context.refresh();

        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();

        context.close();
    }
}
