package com.zgy.study.chapter05.subject02.demo05;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:46 <br>
 * @description ProfilingInterceptor <br>
 */
public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(methodInvocation.getMethod().getName());

        Object proceed = methodInvocation.proceed();
        stopWatch.stop();
        dumpInfo(methodInvocation, stopWatch.getTotalTimeMillis());

        return proceed;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method: " + method.getName());
        System.out.println("On object of type: " + target.getClass().getName());
        System.out.println("With arguments: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(" > " + args[i]);
        }
        System.out.println("\n");

        System.out.println("Took: " + ms + "ms");
    }
}
