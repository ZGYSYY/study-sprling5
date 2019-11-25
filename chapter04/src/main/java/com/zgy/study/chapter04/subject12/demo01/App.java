package com.zgy.study.chapter04.subject12.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:26 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject12/demo01/app-context.xml");
        context.refresh();

        MessageRenderer messageRenderer = context.getBean("standardOutMessageRenderer", MessageRenderer.class);
        messageRenderer.render();

        context.close();
    }
}
