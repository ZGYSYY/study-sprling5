package com.zgy.study.setter4injection;

import com.zgy.study.setter4injection.demo17.InjectSimple;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo17Application <br>
 * @version: 1.0 <br>
 */
public class Demo17Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo17-app-context.xml");
        context.refresh();

        InjectSimple injectSimple = context.getBean("injectSimple", InjectSimple.class);
        System.out.println(injectSimple.toString());

        context.close();
    }
}
