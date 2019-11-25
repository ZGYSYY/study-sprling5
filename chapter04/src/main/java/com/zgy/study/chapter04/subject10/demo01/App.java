package com.zgy.study.chapter04.subject10.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * @author ZGY <br>
 * @date 2019/11/25 10:10 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject10/demo01/app-context.xml");
        context.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(context.getMessage("msg", null, english));
//        System.out.println(context.getMessage("msg", null, german));

//        System.out.println(context.getMessage("nameMsg", new Object[] {"Z","GY"}, english));
//        System.out.println(context.getMessage("nameMsg", new Object[] {"Z","GY"}, german));

        context.close();
    }
}
