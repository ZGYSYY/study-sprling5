package com.zgy.study.chapter02.helloworld;

/**
 * @author ZGY <br>
 * @date 2019/11/19 11:53 <br>
 * @description 代码2 HelloWorldWithCommandLine <br>
 */
public class HelloWorldWithCommandLine {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello world!");
        }
    }
}
