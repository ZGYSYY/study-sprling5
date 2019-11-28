package com.zgy.study.chapter06.subject02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/28 17:44 <br>
 * @description App <br>
 */
public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("开始记录日志=================");
        LOGGER.info("好哈学习，天天向上");
    }
}
