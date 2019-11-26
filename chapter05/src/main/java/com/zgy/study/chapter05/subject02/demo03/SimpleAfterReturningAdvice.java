package com.zgy.study.chapter05.subject02.demo03;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:11 <br>
 * @description SimpleAfterReturningAdvice <br>
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After '" + method.getName() + "' put down guitar.");
    }
}
