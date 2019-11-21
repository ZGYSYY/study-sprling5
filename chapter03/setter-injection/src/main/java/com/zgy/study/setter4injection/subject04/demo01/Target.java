package com.zgy.study.setter4injection.subject04.demo01;

/**
 * @author ZGY <br>
 * @date 2019/11/21 11:47 <br>
 * @description Target <br>
 */
public class Target {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target() {

    }

    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }
}
