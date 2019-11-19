package com.zgy.study.chapter03.dependencypull;

import com.zgy.study.chapter02.helloworld.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/19 15:09 <br>
 * @description DependencyPull <br>
 */
public class DependencyPull {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app-context.xml");
        MessageRenderer renderer = applicationContext.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
