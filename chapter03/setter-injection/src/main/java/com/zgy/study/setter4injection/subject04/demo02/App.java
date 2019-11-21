package com.zgy.study.setter4injection.subject04.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 14:37 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject04/demo02/app-context.xml");
        context.refresh();

        Target target = context.getBean("target", Target.class);

        context.close();
    }
}
