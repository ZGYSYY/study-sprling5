package com.zgy.study.chapter05.subject07.demo03;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/28 9:53 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject07/demo03/app-context.xml");
        context.refresh();

        Contact proxy = context.getBean("proxy", Contact.class);
        IsModified isModified = (IsModified) proxy;

        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));

        System.out.println("Has been modified?: " + isModified.isModified());

        proxy.setName("ZGY");
        System.out.println("Has been modified?: " + isModified.isModified());

        proxy.setName("LHM");
        System.out.println("Has been modified?: " + isModified.isModified());
    }
}
