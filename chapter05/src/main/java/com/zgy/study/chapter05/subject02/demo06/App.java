package com.zgy.study.chapter05.subject02.demo06;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 16:17 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleThrowsAdvice());
        proxyFactory.setTarget(errorBean);

        ErrorBean proxy = (ErrorBean) proxyFactory.getProxy();
        try {
            proxy.errorProneMethod();
        } catch (Exception e) {
        }

        try {
            proxy.otherErrorProneMethod();
        } catch (IllegalArgumentException e) {
        }
    }
}
