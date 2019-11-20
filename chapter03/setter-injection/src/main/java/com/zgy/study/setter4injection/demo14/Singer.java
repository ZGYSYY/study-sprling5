package com.zgy.study.setter4injection.demo14;

/**
 * @author ZGY <br>
 * @date 2019/11/20 10:12 <br>
 * @description Singer <br>
 */
public class Singer {

    private Inspiration inspiration;

    public void sing() {
        System.out.println("..." + inspiration.getLyric());
    }
}
