package com.zgy.study.chapter05.subject04.demo01;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/27 11:06 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        SimpleBean simpleBean = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
        runCglibTests(advisor, simpleBean);
        runCglibFrozenTests(advisor, simpleBean);
        runJdkTests(advisor, simpleBean);
    }

    private static void runCglibTests(Advisor advisor, SimpleBean target) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
    }

    public static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setFrozen(true);

        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        System.out.println("Running CGLIB (Frozen) Tests");
        test(proxy);
    }

    public static void runJdkTests(Advisor advisor, SimpleBean target) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setInterfaces(new Class[]{SimpleBean.class});
        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
    }

    private static void test(SimpleBean simpleBean) {
        long before = 0;
        long after = 0;
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            simpleBean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            simpleBean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            simpleBean.equals(simpleBean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            simpleBean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        Advised advised = (Advised) simpleBean;
        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println(">>> \n");
    }
}
