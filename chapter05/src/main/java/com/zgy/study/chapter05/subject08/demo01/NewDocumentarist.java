package com.zgy.study.chapter05.subject08.demo01;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZGY <br>
 * @date 2019/11/28 12:09 <br>
 * @description NewDocumentarist <br>
 */
@Component("documentarist")
public class NewDocumentarist {

    private GrammyGuitarist grammyGuitarist;

    @Resource(name = "johnMayer")
    public void setGrammyGuitarist(GrammyGuitarist grammyGuitarist) {
        this.grammyGuitarist = grammyGuitarist;
    }

    public void execute() {
        grammyGuitarist.sing();

        Guitar guitar = new Guitar();
        guitar.setName("Gibson");
        grammyGuitarist.sing(guitar);

        grammyGuitarist.talk();
    }
}
