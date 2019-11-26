package com.zgy.study.chapter05.subject01.demo01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ZGY <br>
 * @date 2019/11/26 13:29 <br>
 * @description AgentDecorator <br>
 */
public class AgentDecorator implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("James ");
        Object proceed = methodInvocation.proceed();
        System.out.print("!");

        return proceed;
    }
}
