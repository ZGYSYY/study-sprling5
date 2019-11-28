package com.zgy.study.chapter05.subject07.demo07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

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

    public Object simpleAroundAdvice(ProceedingJoinPoint point, Guitar guitar) throws Throwable {
        System.out.println("Before Executing: " + point.getSignature().getDeclaringTypeName()
                + " " + point.getSignature().getName()
                + " argument: " + guitar.getBrand());

        Object proceed = point.proceed();

        System.out.println("After Executing: " + point.getSignature().getDeclaringTypeName()
                + " " + point.getSignature().getName()
                + " argument: " + guitar.getBrand());

        return proceed;
    }
}
