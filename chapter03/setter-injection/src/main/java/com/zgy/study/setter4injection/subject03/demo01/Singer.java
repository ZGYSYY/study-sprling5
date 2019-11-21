package com.zgy.study.setter4injection.subject03.demo01;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author ZGY <br>
 * @date 2019/11/21 11:23 <br>
 * @description Singer <br>
 */
public class Singer implements ApplicationContextAware {

    private ApplicationContext context;

    private Guitar guitar;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void sing() {
        guitar = context.getBean("gopher", Guitar.class);
        guitar.sing();
    }
}
