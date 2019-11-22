package com.zgy.study.chapter04.subject08.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/22 13:46 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject08/demo01/app-context.xml");
        context.refresh();

        MessageDigester messageDigester = context.getBean("messageDigester", MessageDigester.class);
        messageDigester.digest("OJBK，12345，上山打老虎！");

        context.close();
    }
}
