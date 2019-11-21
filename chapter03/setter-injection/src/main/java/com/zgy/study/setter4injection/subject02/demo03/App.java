package com.zgy.study.setter4injection.subject02.demo03;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ZGY <br>
 * @date 2019/11/21 10:08 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject02/demo03/app-context.xml");
        context.refresh();

        Map<String, String> map = context.getBeansOfType(String.class);
        map.entrySet().stream().forEach(b -> {
            System.out.println("id: " + b.getKey() + "\n aliases: " + Arrays.toString(context.getAliases(b.getKey())) + "\n");
        });

        context.close();
    }
}
