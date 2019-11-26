package com.zgy.study.chapter05.subject02.demo02;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:36 <br>
 * @description SecurityAdvice <br>
 */
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo loggedOnUser = securityManager.getLoggedOnUser();
        if (loggedOnUser == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if ("ZGY".equals(loggedOnUser.getUserName())) {
            System.out.println("Logged in user is ZGY - OKAY!");
        } else {
            System.out.println("Logged in user is " + loggedOnUser.getUserName() + " Not GOOD:(");
            throw new SecurityException("User " + loggedOnUser.getUserName() + " is not allowed access to method " + method.getName());
        }
    }
}
