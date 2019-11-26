package com.zgy.study.chapter05.subject02.demo06;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 16:11 <br>
 * @description SimpleThrowsAdvice <br>
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception e) throws Throwable{
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + e.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException e) throws Throwable{
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " + e.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}
