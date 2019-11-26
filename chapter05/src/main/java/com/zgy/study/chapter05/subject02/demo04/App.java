package com.zgy.study.chapter05.subject02.demo04;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:29 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();
        for (int i = 0; i < 10; i++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("key : " + key);
            } catch (Exception e) {
                System.out.println("Weak Key Generated!");
            }
        }
    }

    public static KeyGenerator getKeyGenerator() {
        KeyGenerator keyGenerator = new KeyGenerator();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new WeakKeyCheckAdvice());
        proxyFactory.setTarget(keyGenerator);

        return (KeyGenerator) proxyFactory.getProxy();
    }
}
