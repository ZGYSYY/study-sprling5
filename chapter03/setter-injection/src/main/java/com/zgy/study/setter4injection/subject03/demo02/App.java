package com.zgy.study.setter4injection.subject03.demo02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/21 11:26 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
    }
}
