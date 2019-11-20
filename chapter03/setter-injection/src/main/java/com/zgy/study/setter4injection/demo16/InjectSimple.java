package com.zgy.study.setter4injection.demo16;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/20 10:51 <br>
 * @description InjectSimple <br>
 */
@Component
public class InjectSimple {

    @Value("ZGY")
    private String name;

    @Value("10")
    private int age;

    @Value("88.8")
    private float height;

    @Value("true")
    private boolean programmer;

    @Value("8501578145")
    private Long ageInSeconds;

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/demo16-app-context.xml");
        context.refresh();

        InjectSimple injectSimple = context.getBean("injectSimple", InjectSimple.class);
        System.out.println(injectSimple);
    }
}
