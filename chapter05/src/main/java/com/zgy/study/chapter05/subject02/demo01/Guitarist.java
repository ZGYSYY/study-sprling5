package com.zgy.study.chapter05.subject02.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:05 <br>
 * @description Guitarist <br>
 */
public class Guitarist implements Singer {

    private String lyric = "左边跟我一起画个龙";
    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
