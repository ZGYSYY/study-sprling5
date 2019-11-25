package com.zgy.study.chapter04.subject13.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/25 16:01 <br>
 * @description App <br>
 */

public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("kindergarten");
        context.load("classpath:subject13/demo01/*-app-context.xml");
        context.refresh();

        FoodProviderService foodProviderService = context.getBean("foodProviderService", FoodProviderService.class);
        List<Food> foods = foodProviderService.providerLunchSet();
        for (Food food : foods) {
            System.out.println("Food: " + food.getName());
        }

        context.close();
    }
}
