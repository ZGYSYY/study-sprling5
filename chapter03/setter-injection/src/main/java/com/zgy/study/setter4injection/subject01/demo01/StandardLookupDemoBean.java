package com.zgy.study.setter4injection.subject01.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/20 14:56 <br>
 * @description StandardLookupDemoBean <br>
 */
public class StandardLookupDemoBean implements DemoBean{

    private Singer singer;

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public Singer getMySinger() {
        return this.singer;
    }

    @Override
    public void doSomething() {
        singer.sing();
    }
}
