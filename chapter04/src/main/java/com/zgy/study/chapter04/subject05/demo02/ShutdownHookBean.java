package com.zgy.study.chapter04.subject05.demo02;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/22 10:19 <br>
 * @description ShutdownHookBean <br>
 */
public class ShutdownHookBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof GenericApplicationContext) {
            System.out.println("访问了 setApplicationContext(ApplicationContext applicationContext) 方法");
            ((GenericApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}
