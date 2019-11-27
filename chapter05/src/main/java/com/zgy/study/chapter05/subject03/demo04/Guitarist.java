package com.zgy.study.chapter05.subject03.demo04;

/**
 * @author ZGY <br>
 * @date 2019/11/27 10:04 <br>
 * @description Guitarist <br>
 */
public class Guitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2() {
        System.out.println("Just keep me where the light is");
    }

    public void rest() {
        System.out.println("zzz");
    }
}
