package com.zgy.study.chapter04.subject12.demo03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:39 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();

        context.close();
    }
}
