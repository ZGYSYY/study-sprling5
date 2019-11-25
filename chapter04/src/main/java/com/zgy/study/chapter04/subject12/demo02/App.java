package com.zgy.study.chapter04.subject12.demo02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:30 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();

        context.close();
    }
}
