package com.zgy.study.chapter05.subject03.demo02;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 17:40 <br>
 * @description SimpleDynamicPointcut <br>
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for " + method.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("Dynamic check for " + method.getName());
        int value = ((Integer) objects[0]).intValue();
        return value != 100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return x -> x == SimpleBean.class;
    }

}
