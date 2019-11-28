package com.zgy.study.chapter05.subject07.demo04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/28 10:04 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
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
