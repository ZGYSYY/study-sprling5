package com.zgy.study.setter4injection.demo17;


/**
 * @author ZGY <br>
 * @date 2019/11/20 10:51 <br>
 * @description InjectSimple <br>
 */
public class InjectSimpleConfig {

    private String name = "欧米伽";

    private int age = 100;

    private float height = 3.14f;

    private boolean programmer = false;

    private Long ageInSeconds = 10000000000L;

    public InjectSimpleConfig() {
        System.out.println("InjectSimpleConfig(): " + toString());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimpleConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
