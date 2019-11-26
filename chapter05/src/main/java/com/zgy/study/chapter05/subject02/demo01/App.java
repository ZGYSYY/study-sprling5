package com.zgy.study.chapter05.subject02.demo01;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:08 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing();
    }
}
