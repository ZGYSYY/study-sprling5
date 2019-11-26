package com.zgy.study.chapter04.subject15.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZGY <br>
 * @date 2019/11/26 10:09 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.refresh();

        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String, Object> map = new HashMap<>();
        map.put("user.home", "application_home");

        propertySources.addFirst(new MapPropertySource("study-spring5", map));

        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));

        System.out.println("user.home: " + environment.getProperty("user.home"));
        System.out.println("JAVA_HOME:" + environment.getProperty("JAVA_HOME"));
    }
}
