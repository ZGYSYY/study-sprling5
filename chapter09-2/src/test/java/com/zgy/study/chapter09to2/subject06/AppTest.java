package com.zgy.study.chapter09to2.subject06;

import com.zgy.study.chapter09to2.subject06.config.AppConfig;
import com.zgy.study.chapter09to2.subject06.entity.Singer;
import com.zgy.study.chapter09to2.subject06.service.SingerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 17:45 <br/>
 * @description AppTest <br/>
 */
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    private AnnotationConfigApplicationContext context;

    private SingerService singerService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        singerService = context.getBean("singerServiceImpl", SingerService.class);
    }

    @Test
    public void test() throws ParseException {
        Singer singer = new Singer();
        singer.setFirstName("C");
        singer.setLastName("G");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));
        singerService.save(singer);
    }

    @Test
    public void test2() {
        List<Singer> singerList = singerService.findAll();
        for (Singer singer : singerList) {
            LOGGER.info("singer: [{}]", singer);
        }
    }

    @Test
    public void test3() {
        Singer singer = singerService.findById(3L);
        singer.setLastName("GZ");
        singerService.save(singer);
    }

    @Test
    public void test4() throws ParseException {
        Singer singer = singerService.findById(1L);
//        Singer singer = new Singer();
        singer.setFirstName("T");
        singer.setLastName("GY");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));
        singerService.saveInJTA(singer);
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
