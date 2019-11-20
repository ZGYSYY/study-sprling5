package com.zgy.study.setter4injection.subject01.demo02;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/20 14:58 <br>
 * @description AbstractLookupDemoBean <br>
 */

@Component
public class AbstractLookupDemoBean implements DemoBean {
    @Override
    @Lookup("singer")
    public Singer getMySinger(){
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
