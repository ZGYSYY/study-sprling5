package com.zgy.study.chapter05.subject07.demo07;

/**
 * @author ZGY <br>
 * @date 2019/11/27 16:38 <br>
 * @description Documentarist <br>
 */
public class Documentarist {

    protected GrammyGuitarist guitarist;

    public void execute() {
        guitarist.sing();
        guitarist.talk();
    }

    public void setSetGuitarist(GrammyGuitarist guitarist) {
        this.guitarist = guitarist;
    }
}
