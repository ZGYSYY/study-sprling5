package com.zgy.study.chapter05.subject08.demo02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/28 12:13 <br>
 * @description AnnotatedAdvice <br>
 */
@Component
@Aspect
public class AnnotatedAdvice {

    @Pointcut("execution(* com.zgy.study.chapter05.subject08.demo02.GrammyGuitarist.sing(com.zgy.study.chapter05.subject08.demo02.Guitar)) && args(guitar)")
    public void singExecution(Guitar guitar) {}

    @Pointcut("bean(john*)")
    public void isJohn(){}

    @Before("singExecution(guitar) && isJohn()")
    public void simpleBeforeAdvice(JoinPoint point, Guitar guitar) {
        if (guitar.getName().equals("Gibson")) {
            System.out.println("Executing: " + point.getSignature().getDeclaringTypeName() + " " + point.getSignature().getName() + " argument: " + guitar.getName());
        }
    }

    @Around("singExecution(guitar) && isJohn()")
    public Object simpleAroundAdvice(ProceedingJoinPoint point, Guitar guitar) throws Throwable {
        System.out.println("Before executing: " + point.getSignature().getDeclaringTypeName() + " " + point.getSignature().getName() + " argument: " + guitar.getName());

        Object proceed = point.proceed();

        System.out.println("After executing: " + point.getSignature().getDeclaringTypeName() + " " +point.getSignature().getName() + "argument: " + guitar.getName());

        return proceed;
    }
}
