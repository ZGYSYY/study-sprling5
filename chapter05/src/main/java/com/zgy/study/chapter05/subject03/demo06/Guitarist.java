package com.zgy.study.chapter05.subject03.demo06;

/**
 * @author ZGY <br>
 * @date 2019/11/27 10:31 <br>
 * @description Guitarist <br>
 */
public class Guitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("Dream of ways to throw it all away");
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }
}
