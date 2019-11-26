package com.zgy.study.chapter05.subject02.demo02;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:45 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        SecurityManager securityManager = null;
        try {
            securityManager = new SecurityManager();
            securityManager.login("LHM", "123456");
            SecureBean secureBean = getSecureBean();
            secureBean.writeSecureMessage();

        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            securityManager.logout();
        }

        securityManager.login("ZGY", "334420");
        SecureBean secureBean2 = getSecureBean();
        secureBean2.writeSecureMessage();
        securityManager.logout();

        try {
            SecureBean secureBean3 = getSecureBean();
            secureBean3.writeSecureMessage();
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            securityManager.logout();
        }

    }

    public static SecureBean getSecureBean() {
        SecureBean secureBean = new SecureBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SecurityAdvice());
        proxyFactory.setTarget(secureBean);

        return (SecureBean) proxyFactory.getProxy();
    }
}
