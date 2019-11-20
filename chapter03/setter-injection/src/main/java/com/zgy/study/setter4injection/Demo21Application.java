package com.zgy.study.setter4injection;

import com.zgy.study.setter4injection.demo21.CollectionInjection;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo21Application <br>
 * @version: 1.0 <br>
 */
public class Demo21Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo21-app-context.xml");
        context.refresh();

        CollectionInjection collectionInjection = context.getBean("collectionInjection", CollectionInjection.class);
        collectionInjection.displayInfo();

        context.close();
    }
}
