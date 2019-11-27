package com.zgy.study.chapter05.subject03.demo04;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * @author ZGY <br>
 * @date 2019/11/27 10:08 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*sing.*");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing();
        proxy.sing2();
        proxy.rest();
    }
}
