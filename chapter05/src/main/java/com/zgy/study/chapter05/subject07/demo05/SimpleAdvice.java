package com.zgy.study.chapter05.subject07.demo05;

import org.aspectj.lang.JoinPoint;

/**
 * @author ZGY <br>
 * @date 2019/11/28 10:21 <br>
 * @description SimpleAdvice <br>
 */
public class SimpleAdvice {

    public void simpleBeforeAdvice(JoinPoint point) {
        System.out.println("Executing: " + point.getSignature().getDeclaringTypeName() + " " + point.getSignature().getName());
    }
}
