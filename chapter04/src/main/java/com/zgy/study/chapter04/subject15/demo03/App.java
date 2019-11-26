package com.zgy.study.chapter04.subject15.demo03;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/26 10:30 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject15/demo03/app-context.xml");
        context.refresh();

        AppProperty appProperty = context.getBean("appProperty", AppProperty.class);
        System.out.println(appProperty);

        context.close();
    }
}
