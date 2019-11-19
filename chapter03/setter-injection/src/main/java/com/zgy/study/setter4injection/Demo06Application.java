package com.zgy.study.setter4injection;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:06 <br>
 * @description: Demo06Application <br>
 * @version: 1.0 <br>
 */
public class Demo06Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo06-app-context.xml");
        context.refresh();

        MessageRenderer renderer = context.getBean("standardOutMessageRenderer", MessageRenderer.class);
        renderer.render();

        context.close();
    }
}
