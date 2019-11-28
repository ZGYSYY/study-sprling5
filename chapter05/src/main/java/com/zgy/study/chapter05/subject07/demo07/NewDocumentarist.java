package com.zgy.study.chapter05.subject07.demo07;

/**
 * @author ZGY <br>
 * @date 2019/11/28 11:08 <br>
 * @description NewDocumentarist <br>
 */
public class NewDocumentarist extends Documentarist {

    @Override
    public void execute() {
        guitarist.sing();
        Guitar guitar = new Guitar();
        guitar.setBrand("Gibson");
        guitarist.sing(guitar);

        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}
