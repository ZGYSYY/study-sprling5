package com.zgy.study.chapter09to2.subject06;

import com.zgy.study.chapter09to2.subject06.config.ServiceConfig;
import com.zgy.study.chapter09to2.subject06.config.XAJapConfig;
import com.zgy.study.chapter09to2.subject06.entity.Singer;
import com.zgy.study.chapter09to2.subject06.service.SingerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 17:45 <br/>
 * @description AppTest <br/>
 */
public class AppTest {

    private AnnotationConfigApplicationContext context;

    private SingerService singerService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(XAJapConfig.class, ServiceConfig.class);
        singerService = context.getBean("singerServiceImpl", SingerService.class);
    }

    @Test
    public void test() throws ParseException {
        Singer singer = new Singer();
        singer.setFirstName("Z");
        singer.setLastName("GY");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));
        singerService.save(singer);
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
