package com.zgy.study.setter4injection.subject01.demo03;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author ZGY <br>
 * @date 2019/11/20 17:33 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/subject01/demo03/app-context.xml");
        context.refresh();

        ReplacementTarget replacementTarget = context.getBean("replacementTarget", ReplacementTarget.class);
        System.out.println(replacementTarget.formatMessage("老子明天不上班"));

        ReplacementTarget replacementTarget2 = context.getBean("replacementTarget2", ReplacementTarget.class);
        System.out.println(replacementTarget2.formatMessage("老子明天要上班。。。"));

        displayInfo(replacementTarget);
        displayInfo(replacementTarget2);
    }

    private static void displayInfo(ReplacementTarget target) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int i = 0; i < 1000000; i++) {
            target.formatMessage("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
        stopWatch.stop();

        System.out.println("1000000 耗时：" + stopWatch.getTotalTimeMillis() + " ms");
    }
}
