package com.zgy.study.setter4injection.subject01.demo03;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/20 17:16 <br>
 * @description FormatMessageReplacer <br>
 */
public class FormatMessageReplacer implements MethodReplacer {
    /**
     * Reimplement the given method.
     *
     * @param obj    the instance we're reimplementing the method for
     * @param method the method to reimplement
     * @param args   arguments to the method
     * @return return value for the method
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String message = (String) args[0];
            return "<h2>" + message + "</h1>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method " + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }
        if (method.getReturnType() != String.class) {
            return false;
        }
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }

        return true;
    }
}
