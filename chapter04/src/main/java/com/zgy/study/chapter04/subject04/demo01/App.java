package com.zgy.study.chapter04.subject04.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 17:12 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DestructiveBean destructiveBean = context.getBean("destructiveBean", DestructiveBean.class);

        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println(tmpdir);

        context.registerShutdownHook();
        context.close();
    }
}
