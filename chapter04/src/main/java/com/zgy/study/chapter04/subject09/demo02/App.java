package com.zgy.study.chapter04.subject09.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/22 17:12 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject09/demo02/app-context.xml");
        context.refresh();

        CustomEditorExample customEditorExample = context.getBean("customEditorExample", CustomEditorExample.class);
        System.out.println(customEditorExample.getName());

        context.close();
    }
}
