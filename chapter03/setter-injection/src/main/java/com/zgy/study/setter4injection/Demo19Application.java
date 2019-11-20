package com.zgy.study.setter4injection;

import com.zgy.study.setter4injection.demo19.InjectRef;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo19Application <br>
 * @version: 1.0 <br>
 */
public class Demo19Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo19-app-context.xml");
        context.refresh();

        InjectRef injectRef = context.getBean("injectRef", InjectRef.class);
        System.out.println(injectRef.toString());

        context.close();
    }
}
