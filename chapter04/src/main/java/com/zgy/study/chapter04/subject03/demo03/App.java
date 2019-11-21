package com.zgy.study.chapter04.subject03.demo03;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 17:12 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject03/demo03/app-context.xml");
        context.refresh();

        DestructiveBean destructiveBean = context.getBean("destructiveBean", DestructiveBean.class);

        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println(tmpdir);
        context.close();
    }
}
