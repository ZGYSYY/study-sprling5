package com.zgy.study.chapter04.subject05.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/22 10:06 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject04/demo01/app-context.xml");
        context.refresh();

        NameSinger nameSinger = context.getBean("nameSinger", NameSinger.class);
        nameSinger.sing();

        context.close();
    }
}
