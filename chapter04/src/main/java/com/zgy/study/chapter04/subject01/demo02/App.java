package com.zgy.study.chapter04.subject01.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 15:52 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject01/demo02/app-context.xml");
        context.refresh();

        Singer singer = context.getBean("singer", Singer.class);
        System.out.println("singer: " + singer + "\n");

        Singer singer2 = context.getBean("singer2", Singer.class);
        System.out.println("singer2: " + singer2 + "\n");

        Singer singer3 = context.getBean("singer3", Singer.class);
        System.out.println("singer3: " + singer3);
    }
}
