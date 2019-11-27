package com.zgy.study.chapter05.subject07.demo02;

/**
 * @author ZGY <br>
 * @date 2019/11/27 16:38 <br>
 * @description Documentarist <br>
 */
public class Documentarist {

    private GrammyGuitarist setGuitarist;

    public void execute() {
        setGuitarist.sing();
        setGuitarist.talk();
    }

    public void setSetGuitarist(GrammyGuitarist setGuitarist) {
        this.setGuitarist = setGuitarist;
    }
}
