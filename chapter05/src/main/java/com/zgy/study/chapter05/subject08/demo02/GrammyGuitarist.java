package com.zgy.study.chapter05.subject08.demo02;

import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/28 12:06 <br>
 * @description GrammyGuitarist <br>
 */
@Component("johnMayer")
public class GrammyGuitarist implements Singer {

    @Override
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
