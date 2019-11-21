package com.zgy.study.chapter04.subject01.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/21 15:47 <br>
 * @description Singer <br>
 */
public class Singer {

    private static final String DEFAULT_NAME = "DEFAULT_NAME";

    private String name;
    private int age = Integer.MIN_VALUE;

    public Singer() {
        System.out.println("执行了构造方法");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        if (name == null) {
            System.out.println("name 为 null，将使用默认的 name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("你必须要设置 age 的值：" + Singer.class);
        }
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
