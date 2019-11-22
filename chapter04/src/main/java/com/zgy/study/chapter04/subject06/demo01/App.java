package com.zgy.study.chapter04.subject06.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/22 11:26 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject06/demo01/app-context.xml");
        context.refresh();

        MessageDigester messageDigester = context.getBean("messageDigester", MessageDigester.class);
        messageDigester.digest("好好学习，天天向上！");

        context.close();
    }
}
