package com.zgy.study.chapter05.subject07.demo05;

/**
 * @author ZGY <br>
 * @date 2019/11/28 10:18 <br>
 * @description NewDocumentarist <br>
 */
public class NewDocumentarist extends Documentarist{

    @Override
    public void execute() {
        guitarist.sing();
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}
