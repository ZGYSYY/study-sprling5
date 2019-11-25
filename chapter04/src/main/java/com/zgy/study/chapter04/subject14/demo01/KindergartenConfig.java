package com.zgy.study.chapter04.subject14.demo01;

import com.zgy.study.chapter04.subject14.demo01.kindergarten.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ZGY <br>
 * @date 2019/11/25 16:51 <br>
 * @description KindergartenConfig <br>
 */
@Configuration
@Profile("kindergarten")
public class KindergartenConfig {

    @Bean
    public FoodProviderService foodProviderService() {

        return new FoodProviderServiceImpl();
    }
}
