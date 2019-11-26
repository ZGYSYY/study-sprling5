package com.zgy.study.chapter05.subject02.demo05;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:45 <br>
 * @description WorkerBean <br>
 */
public class WorkerBean {

    public void doSomeWork(int noOfTimes) {
        for (int i = 0; i < noOfTimes; i++) {
            work();
        }
    }

    private void work() {
        System.out.println("");
    }
}
