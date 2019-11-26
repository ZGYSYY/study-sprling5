package com.zgy.study.chapter04.subject17.demo01;

import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/26 11:40 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("classpath:subject17/demo01/beans.groovy");

        Singer singer = context.getBean("singer", Singer.class);
        System.out.println(singer);

        context.close();
    }
}
