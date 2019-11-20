package com.zgy.study.setter4injection.subject01.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/20 14:58 <br>
 * @description AbstractLookupDemoBean <br>
 */
public abstract class AbstractLookupDemoBean implements DemoBean{
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
