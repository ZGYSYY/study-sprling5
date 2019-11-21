package com.zgy.study.setter4injection.subject04.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 14:19 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject04/demo01/app-context.xml");
        context.refresh();

        Target target = null;

        System.out.println("Using byName: \n");
        target = context.getBean("targetByName", Target.class);

        System.out.println("\nUsing byType: \n");
        target = context.getBean("targetByType", Target.class);

        System.out.println("\nUsing constructor: \n");
        target = context.getBean("targetConstructor", Target.class);
    }
}
