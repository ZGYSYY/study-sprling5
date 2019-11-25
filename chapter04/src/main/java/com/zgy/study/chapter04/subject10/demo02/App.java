package com.zgy.study.chapter04.subject10.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/25 14:24 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject10/demo02/app-context.xml");
        context.refresh();

        Publisher publisher = context.getBean("publisher", Publisher.class);
        publisher.publish("I send and SOS to the world...");
        publisher.publish("... I hope that someone gets my ...");
        publisher.publish("... Message in a bottle");

        context.close();
    }
}
