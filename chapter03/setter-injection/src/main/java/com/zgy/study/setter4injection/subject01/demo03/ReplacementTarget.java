package com.zgy.study.setter4injection.subject01.demo03;

/**
 * @author ZGY <br>
 * @date 2019/11/20 17:14 <br>
 * @description ReplacementTarget <br>
 */
public class ReplacementTarget {

    public String formatMessage(String message) {

        return "<h1>" + message + "</h1>";
    }

    public String formatMessage(Object message) {

        return "<h1>" + message + "</h1>";
    }
}
