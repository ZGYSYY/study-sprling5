package com.zgy.study.chapter05.subject07.demo05;


/**
 * @author ZGY <br>
 * @date 2019/11/27 9:47 <br>
 * @description GrammyGuitarist <br>
 */
public class GrammyGuitarist {

    public void sing() {
        System.out.println("sing: Gravity is working against me\n" + "And gravity wants to bring me down");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }

    public void talk() {
        System.out.println("talk");
    }
}
