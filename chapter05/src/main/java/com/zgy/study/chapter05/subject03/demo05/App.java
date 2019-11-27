package com.zgy.study.chapter05.subject03.demo05;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/27 10:17 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* sing*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(guitarist);
        proxyFactory.addAdvisor(advisor);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing();
        proxy.sing2();
        proxy.rest();
    }
}
