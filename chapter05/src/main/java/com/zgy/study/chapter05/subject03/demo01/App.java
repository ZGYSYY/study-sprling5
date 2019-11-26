package com.zgy.study.chapter05.subject03.demo01;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/26 17:20 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Singer singer = new GoodGuitarist();
        Singer singer2 = new GreatGuitarist();

        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);

        proxyFactory.setTarget(singer);
        Singer proxy = (Singer) proxyFactory.getProxy();
        proxy.sing();

        proxyFactory.setTarget(singer2);
        Singer proxy2 = (Singer) proxyFactory.getProxy();
        proxy2.sing();


    }
}
