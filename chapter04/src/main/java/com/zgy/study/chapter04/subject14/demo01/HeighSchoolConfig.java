package com.zgy.study.chapter04.subject14.demo01;

import com.zgy.study.chapter04.subject14.demo01.heighscholl.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ZGY <br>
 * @date 2019/11/25 16:53 <br>
 * @description HeighSchoolConfig <br>
 */
@Configuration
@Profile("heighscholl")
public class HeighSchoolConfig {

    @Bean
    public FoodProviderService foodProviderService() {

        return new FoodProviderServiceImpl();
    }
}
