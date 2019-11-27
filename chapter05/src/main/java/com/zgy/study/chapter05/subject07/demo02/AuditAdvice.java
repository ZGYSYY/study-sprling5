package com.zgy.study.chapter05.subject07.demo02;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/27 16:42 <br>
 * @description AuditAdvice <br>
 */
public class AuditAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Executing: " + method);
    }
}
