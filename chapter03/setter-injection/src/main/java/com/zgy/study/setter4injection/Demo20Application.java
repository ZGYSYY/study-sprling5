package com.zgy.study.setter4injection;

import com.zgy.study.setter4injection.demo20.Song;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:15 <br>
 * @description: Demo20Application <br>
 * @version: 1.0 <br>
 */
public class Demo20Application {

    public static void main(String[] args) {
        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load("classpath:spring/demo20/parent-context.xml");
        parentContext.refresh();

        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("classpath:spring/demo20/child-context.xml");
        childContext.setParent(parentContext);
        childContext.refresh();

        Song song1 = childContext.getBean("song1", Song.class);
        System.out.println("song1: " + song1.getTitle());
        Song song2 = childContext.getBean("song2", Song.class);
        System.out.println("song2: " + song2.getTitle());
        Song song3 = childContext.getBean("song3", Song.class);
        System.out.println("song3: " + song3.getTitle());

        childContext.close();
        parentContext.close();
    }
}
