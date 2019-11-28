package com.zgy.study.chapter05.subject07.demo06;

import org.aspectj.lang.JoinPoint;

/**
 * @author ZGY <br>
 * @date 2019/11/28 11:09 <br>
 * @description ComplexAdvice <br>
 */
public class ComplexAdvice {

    public void simpleBeforeAdvice (JoinPoint joinPoint, Guitar guitar) {
        if (guitar.getBrand().equals("Gibson")) {
            System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        }
    }
}
