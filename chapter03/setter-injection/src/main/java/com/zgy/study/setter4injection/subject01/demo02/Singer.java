package com.zgy.study.setter4injection.subject01.demo02;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/20 14:54 <br>
 * @description Singer <br>
 */
@Component
@Scope(value = "prototype")
public class Singer {

    private String lyirc = "好好学习，天天向上！";

    public void sing() {
        System.out.println(lyirc);
    }
}
