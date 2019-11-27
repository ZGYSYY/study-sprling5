package com.zgy.study.chapter05.subject05.demo02;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/27 13:46 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Singer grammyGuitarist = new GrammyGuitarist();
        ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());
        System.out.println("Test 1 >> ");
        GrammyGuitarist proxy = getProxy(pointcut, grammyGuitarist);
        testInvoke(proxy);
        System.out.println("");

        System.out.println("Test 2 >> ");
        pointcut.union(new TalkMethodMatcher());
        proxy = getProxy(pointcut, grammyGuitarist);
        testInvoke(proxy);
        System.out.println("");

        System.out.println("Test 3 >> ");
        pointcut.intersection(new RestMethodMatcher());
        proxy = getProxy(pointcut, grammyGuitarist);
        testInvoke(proxy);
        System.out.println("");
    }

    private static GrammyGuitarist getProxy(Pointcut pointcut, Singer target) {
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        return (GrammyGuitarist) proxyFactory.getProxy();
    }

    private static void testInvoke(GrammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }

    private static class SingMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.getName().startsWith("si");
        }
    }

    private static class TalkMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "talk".equals(method.getName());
        }
    }

    private static class RestMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.getName().endsWith("st");
        }
    }
}
