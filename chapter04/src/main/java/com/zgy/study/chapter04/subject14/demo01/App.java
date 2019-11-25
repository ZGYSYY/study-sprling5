package com.zgy.study.chapter04.subject14.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/25 16:56 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HeighSchoolConfig.class, KindergartenConfig.class);

        FoodProviderService foodProviderService = context.getBean("foodProviderService", FoodProviderService.class);
        List<Food> foods = foodProviderService.providerLunchSet();
        for (Food food : foods) {
            System.out.println("Food :" + food.getName());
        }

        context.close();
    }
}
