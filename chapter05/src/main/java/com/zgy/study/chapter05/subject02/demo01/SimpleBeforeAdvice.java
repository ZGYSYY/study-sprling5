package com.zgy.study.chapter05.subject02.demo01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:06 <br>
 * @description SimpleBeforeAdvice <br>
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before '" + method.getName() + "', tune guitar.");
    }
}
