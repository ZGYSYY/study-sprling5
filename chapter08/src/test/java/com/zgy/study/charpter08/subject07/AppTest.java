package com.zgy.study.charpter08.subject07;

import com.zgy.study.chapter08.subject07.config.DataJpaConfig;
import com.zgy.study.chapter08.subject07.entity.Singer;
import com.zgy.study.chapter08.subject07.service.SingerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 14:03 <br/>
 * @description AppTest <br/>
 */
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    private AnnotationConfigApplicationContext context;

    private SingerService singerService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        singerService = context.getBean("singerServiceImpl", SingerService.class);
    }

    @Test
    public void test() {
        List<Singer> singerList = singerService.findAll();
        for (Singer singer : singerList) {
            LOGGER.info("singer : [{}]", singer);
        }
    }

    @Test
    public void test2 () {
        List<Singer> singerList = singerService.findByFirstName("John");
        for (Singer singer : singerList) {
            LOGGER.info("singer : [{}]", singer);
        }
    }

    @Test
    public void test3() {
        List<Singer> singerList = singerService.findByFirstNameAndLastName("John", "Mayer");
        for (Singer singer : singerList) {
            LOGGER.info("singer : [{}]", singer);
        }
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
