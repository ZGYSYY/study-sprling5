package com.zgy.study.chapter05.subject06.demo01;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/27 15:01 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setName("ZGY");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(contact);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        Contact proxy = (Contact) pf.getProxy();
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
