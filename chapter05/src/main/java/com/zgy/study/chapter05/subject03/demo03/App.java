package com.zgy.study.chapter05.subject03.demo03;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author ZGY <br>
 * @date 2019/11/27 9:53 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GrammyGuitarist grammyGuitarist = new GrammyGuitarist();
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.addMethodName("sing");
        nameMatchMethodPointcut.addMethodName("rest");

        Advisor advisor = new DefaultPointcutAdvisor(nameMatchMethodPointcut, new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(grammyGuitarist);
        proxyFactory.addAdvisor(advisor);

        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
