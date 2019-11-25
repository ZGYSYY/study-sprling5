package com.zgy.study.chapter04.subject14.demo01.heighscholl;

import com.zgy.study.chapter04.subject14.demo01.Food;
import com.zgy.study.chapter04.subject14.demo01.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/25 15:53 <br>
 * @description FoodProviderServiceImpl <br>
 */
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> providerLunchSet() {
        List<Food> lunchSet = new ArrayList<>(3);
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));

        return lunchSet;
    }
}
