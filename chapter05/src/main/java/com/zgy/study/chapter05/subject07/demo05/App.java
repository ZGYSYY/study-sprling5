package com.zgy.study.chapter05.subject07.demo05;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/28 10:42 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject07/demo05/app-context.xml");
        context.refresh();

        NewDocumentarist newDocumentarist = context.getBean("newDocumentarist", NewDocumentarist.class);
        newDocumentarist.execute();

        context.close();
    }
}
