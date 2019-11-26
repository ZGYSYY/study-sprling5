package com.zgy.study.chapter05.subject02.demo03;

import com.zgy.study.chapter05.subject02.demo01.SimpleBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:12 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Singer singer = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(singer);

        Singer proxy = (Singer) proxyFactory.getProxy();
        proxy.sing();
    }
}
