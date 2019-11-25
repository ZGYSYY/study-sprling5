package com.zgy.study.chapter04.subject11.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * @author ZGY <br>
 * @date 2019/11/25 14:39 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        Resource resource = context.getResource("file://" + file.getPath());
        displayInfo(resource);

        Resource resource2 = context.getResource("classpath:subject11/demo01/test.txt");
        displayInfo(resource2);

        Resource resource3 = context.getResource("http://www.baidu.com");
        displayInfo(resource3);
    }

    public static void displayInfo(Resource resource) throws IOException {
        System.out.println(resource.getClass());
        System.out.println(resource.getURL());
        System.out.println("");
    }
}
