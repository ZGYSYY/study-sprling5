package com.zgy.study.chapter05.subject07.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/27 16:55 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject07/demo02/app-context.xml");
        context.refresh();

        Documentarist documentaristOne = context.getBean("documentaristOne", Documentarist.class);
        Documentarist documentaristTwo = context.getBean("documentaristTwo", Documentarist.class);

        System.out.println("documentarist One >>");
        documentaristOne.execute();

        System.out.println("documentarist Two >>");
        documentaristTwo.execute();
    }
}
