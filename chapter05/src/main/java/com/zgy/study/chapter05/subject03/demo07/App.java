package com.zgy.study.chapter05.subject03.demo07;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/27 10:39 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GrammyGuitarist grammyGuitarist = new GrammyGuitarist();
        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        nameMatchMethodPointcutAdvisor.addMethodName("sing");
        nameMatchMethodPointcutAdvisor.addMethodName("rest");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(grammyGuitarist);
        proxyFactory.addAdvisor(nameMatchMethodPointcutAdvisor);
        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
