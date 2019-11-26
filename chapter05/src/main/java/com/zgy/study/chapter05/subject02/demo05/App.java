package com.zgy.study.chapter05.subject02.demo05;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:52 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        WorkerBean workerBean = new WorkerBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(workerBean);
        proxyFactory.addAdvice(new ProfilingInterceptor());
        WorkerBean proxy = (WorkerBean) proxyFactory.getProxy();
        proxy.doSomeWork(100000);
    }
}
