package com.zgy.study.chapter05.subject03.demo03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ZGY <br>
 * @date 2019/11/26 17:18 <br>
 * @description SimpleAdvice <br>
 */
public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking " + methodInvocation.getMethod().getName());
        Object proceed = methodInvocation.proceed();
        System.out.println(">> Done\n");

        return proceed;
    }
}
