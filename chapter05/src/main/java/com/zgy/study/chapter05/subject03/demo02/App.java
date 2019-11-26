package com.zgy.study.chapter05.subject03.demo02;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/26 17:48 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        SimpleBean simpleBean = new SimpleBean();
        Pointcut pointcut = new SimpleDynamicPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(simpleBean);

        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        proxy.foo(99);
        proxy.foo(100);
        proxy.foo(101);
        proxy.bar();
        proxy.bar();
        proxy.bar();
    }
}
