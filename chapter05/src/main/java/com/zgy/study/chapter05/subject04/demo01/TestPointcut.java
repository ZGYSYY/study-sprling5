package com.zgy.study.chapter05.subject04.demo01;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/27 11:02 <br>
 * @description TestPointcut <br>
 */
public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "advise".equals(method.getName());
    }
}
