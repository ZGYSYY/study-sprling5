package com.zgy.study.chapter05.subject02.demo04;

import java.util.Random;

/**
 * @author ZGY <br>
 * @date 2019/11/26 15:21 <br>
 * @description KeyGenerator <br>
 */
public class KeyGenerator {

    public static final long WEAK_KEY = 0XFFFFFFF0000000L;
    public static final long STRONG_KEY = 0XACDF03F590AE56L;

    private Random random = new Random();

    public long getKey() {
        int x = random.nextInt(3);
        if (x == 1) {
            return WEAK_KEY;
        }

        return STRONG_KEY;
    }
}
