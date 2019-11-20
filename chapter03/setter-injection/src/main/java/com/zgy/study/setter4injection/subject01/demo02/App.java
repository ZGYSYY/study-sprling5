package com.zgy.study.setter4injection.subject01.demo02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author ZGY <br>
 * @date 2019/11/20 15:13 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DemoBean abstractLookupDemoBean = context.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardLookupDemoBean = context.getBean("standardLookupDemoBean", DemoBean.class);

        displayInfo("abstractLookupDemoBean", abstractLookupDemoBean);
        displayInfo("standardLookupDemoBean", standardLookupDemoBean);

        context.close();
    }

    public static void displayInfo(String name, DemoBean bean) {
        Singer mySinger = bean.getMySinger();
        Singer mySinger2 = bean.getMySinger();

        System.out.println("" + name + ": Singer Instances the Same?" + (mySinger == mySinger2));
        /*StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i < 100000; i++) {
            Singer singer = bean.getMySinger();
            singer.sing();
        }
        stopWatch.stop();

        System.out.println("100 gets took " + stopWatch.getTotalTimeMillis() + "ms");*/
    }
}
