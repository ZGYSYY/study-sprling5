package com.zgy.study.spring5.base.dao;

import com.zgy.study.spring5.base.dao.entity.Singer;
import com.zgy.study.spring5.base.dao.service.SingerService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/14 17:12 <br>
 * @description BaseDaoApplication2，使用 AOP 事务 <br>
 */
public class BaseDaoApplication2 {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/tx-declarative-app-context.xml");
        context.refresh();

        SingerService singerService = context.getBean(SingerService.class);

        // Testing findAll()
        List<Singer> singerList = singerService.findAll();
        singerList.forEach(s -> System.out.println(s));

        // Testing save()
        Singer singer = singerService.findById(1L);
        singer.setFirstName("Z");
        singer.setLastName("GY");
        System.out.println("Singer saved successfully: " + singer);

        // Testing countAll()
        System.out.println("Singer count: " + singerService.countAll());

        context.close();
    }
}
