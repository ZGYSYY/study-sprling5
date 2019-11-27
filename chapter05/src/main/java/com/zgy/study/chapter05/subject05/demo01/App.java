package com.zgy.study.chapter05.subject05.demo01;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/27 12:01 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        TestBean testBean = new TestBean();
        ControlFlowPointcut controlFlowPointcut = new ControlFlowPointcut(App.class, "test");
        ProxyFactory proxyFactory = new ProxyFactory();
        Advisor advisor = new DefaultPointcutAdvisor(controlFlowPointcut, new SimpleBeforeAdvice());
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(testBean);
        TestBean proxy = (TestBean) proxyFactory.getProxy();
        System.out.println("\tTrying normal invoke");
        proxy.foo();

        System.out.println("\n\tTrying under App.test()");
        test(proxy);
    }

    private static void test(TestBean testBean) {
        testBean.foo();
    }
}
