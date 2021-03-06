package com.zgy.study.setter4injection;


import com.zgy.study.setter4injection.demo14.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo14Application <br>
 * @version: 1.0 <br>
 */
public class Demo14Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo14-app-context.xml");
        context.refresh();

        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();

        context.close();
    }
}
