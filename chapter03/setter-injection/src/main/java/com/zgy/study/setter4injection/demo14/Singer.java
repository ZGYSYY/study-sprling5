package com.zgy.study.setter4injection.demo14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/20 10:12 <br>
 * @description Singer <br>
 */
@Component
public class Singer {

    @Autowired
    private Inspiration inspiration;

    public void sing() {
        System.out.println("..." + inspiration.getLyric());
    }
}
