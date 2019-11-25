package com.zgy.study.chapter04.subject13.demo02;

import com.zgy.study.chapter04.subject13.demo02.heighscholl.FoodProviderServiceImpl;
import org.springframework.context.annotation.*;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/25 16:18 <br>
 * @description App <br>
 */
public class App {

    @Configuration
    @ComponentScan(basePackages = "com.zgy.study.chapter04.subject13.demo02")
    public static class Config{
        @Profile("heighscholl")
        @Bean("foodProviderService")
        public FoodProviderService foodProviderService() {

            return new FoodProviderServiceImpl();
        }

        @Profile("kindergarten")
        @Bean("foodProviderService")
        public FoodProviderService foodProviderService2() {

            return new com.zgy.study.chapter04.subject13.demo02.kindergarten.FoodProviderServiceImpl();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("kindergarten");
        context.register(App.Config.class);
        context.refresh();

        FoodProviderService foodProviderService = context.getBean("foodProviderService", FoodProviderService.class);
        List<Food> foods = foodProviderService.providerLunchSet();
        for (Food food : foods) {
            System.out.println("Food :" + food.getName());
        }
    }
}
