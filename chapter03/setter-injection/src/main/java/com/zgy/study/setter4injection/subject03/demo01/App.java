package com.zgy.study.setter4injection.subject03.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 11:26 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject03/demo01/app-context.xml");
        context.refresh();

        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
    }
}
