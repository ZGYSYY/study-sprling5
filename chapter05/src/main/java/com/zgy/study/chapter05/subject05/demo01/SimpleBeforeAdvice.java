package com.zgy.study.chapter05.subject05.demo01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/27 12:00 <br>
 * @description SimpleBeforeAdvice <br>
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
