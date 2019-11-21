package com.zgy.study.setter4injection.subject02.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

/**
 * @author ZGY <br>
 * @date 2019/11/21 10:08 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject02/demo02/app-context.xml");
        context.refresh();

        String john = context.getBean("john", String.class);
        String johnny = context.getBean("johnny", String.class);
        String jonathan = context.getBean("jonathan", String.class);
        String jim = context.getBean("jim", String.class);
        String ion = context.getBean("ion", String.class);

        System.out.println(john == johnny);
        System.out.println(johnny == jonathan);
        System.out.println(jonathan == johnny);
        System.out.println(john == jim);
        System.out.println(jim == ion);

        Map<String, String> map = context.getBeansOfType(String.class);
        if (map.size() == 1) {
            System.out.println("只有一个 String 类型的实例！");
        }

        context.close();
    }
}
