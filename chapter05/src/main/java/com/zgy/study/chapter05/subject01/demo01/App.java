package com.zgy.study.chapter05.subject01.demo01;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 13:32 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        Agent agent = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(agent);
        Agent proxy = (Agent) proxyFactory.getProxy();

        agent.speck();
        System.out.println("");
        proxy.speck();
    }
}
