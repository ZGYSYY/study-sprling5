package com.zgy.study.chapter05.subject04.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/27 11:00 <br>
 * @description DefaultSimpleBean <br>
 */
public class DefaultSimpleBean implements SimpleBean {

    private long dummy = 0L;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
