package com.zgy.study.setter4injection;

import com.zgy.study.setter4injection.demo18.InjectSimple;
import com.zgy.study.setter4injection.demo18.InjectSimpleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo18Application <br>
 * @version: 1.0 <br>
 */
public class Demo18Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectSimpleConfig.class);
        InjectSimple injectSimple = context.getBean("injectSimple", InjectSimple.class);
        System.out.println(injectSimple);

        context.close();
    }
}
