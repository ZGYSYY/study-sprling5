package com.zgy.study.setter4injection.subject05.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/21 14:56 <br>
 * @description Singer <br>
 */
public class Singer {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
