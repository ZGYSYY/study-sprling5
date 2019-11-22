package com.zgy.study.chapter04.subject05.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/22 10:34 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject04/demo02/app-context.xml");
        context.refresh();

        DestructiveBeanWithInterface destructiveBeanWithInterface = context.getBean("destructiveBeanWithInterface", DestructiveBeanWithInterface.class);

        ShutdownHookBean shutdownHookBean = context.getBean("shutdownHookBean", ShutdownHookBean.class);
//        context.close();
    }
}
