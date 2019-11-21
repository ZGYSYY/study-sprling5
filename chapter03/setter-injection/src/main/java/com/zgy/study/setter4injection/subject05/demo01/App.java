package com.zgy.study.setter4injection.subject05.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 14:58 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject05/demo01/app-context.xml");
        context.refresh();

        /*Singer parentSinger = context.getBean("parentSinger", Singer.class);
        System.out.println(parentSinger);*/

        Singer childSinger = context.getBean("childSinger", Singer.class);
        System.out.println(childSinger);
    }
}
