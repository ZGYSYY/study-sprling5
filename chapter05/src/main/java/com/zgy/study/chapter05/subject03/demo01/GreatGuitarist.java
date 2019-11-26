package com.zgy.study.chapter05.subject03.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/26 17:15 <br>
 * @description GreatGuitarist <br>
 */
public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n" + "But I did not shoot the deputy");
    }
}
