package com.zgy.study.chapter05.subject08.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/27 9:50 <br>
 * @description Guitar <br>
 */
public class Guitar {

    private String name = "ZGY";

    public String play() {

        return "G C G C Am D7";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
