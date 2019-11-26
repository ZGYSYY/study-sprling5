package com.zgy.study.chapter05.subject03.demo01;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 17:16 <br>
 * @description SimpleStaticPointcut <br>
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "sing".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == GoodGuitarist.class;
            }
        };
    }
}
