package com.zgy.study.chapter05.subject03.demo06;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * @author ZGY <br>
 * @date 2019/11/27 10:32 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(guitarist);
        proxyFactory.addAdvisor(advisor);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
    }
}
