package com.zgy.study.chapter05.subject07.demo06;

/**
 * @author ZGY <br>
 * @date 2019/11/28 11:05 <br>
 * @description Guitar <br>
 */
public class Guitar {

    private String brand = "Martin";

    public String play() {
        return "G C G C Am D7";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
