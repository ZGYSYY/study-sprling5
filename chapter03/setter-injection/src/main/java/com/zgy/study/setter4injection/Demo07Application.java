package com.zgy.study.setter4injection;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo07Application <br>
 * @version: 1.0 <br>
 */
public class Demo07Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo07-app-context.xml");
        context.refresh();

        MessageProvider provider = context.getBean("configurableMessageProvider", MessageProvider.class);
        System.out.println(provider.getMessage());

        context.close();
    }
}
