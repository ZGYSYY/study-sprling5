package com.zgy.study.chapter06.subject13.demo01;

import com.zgy.study.chapter06.subject13.demo01.config.AppConfig;
import com.zgy.study.chapter06.subject13.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject13.demo01.entities.Singer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/12/2 13:57 <br>
 * @description AppTest <br>
 */
public class AppTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    private SingerDao singerDao;

    private AnnotationConfigApplicationContext context;

    @Before
    public void before() {
        LOGGER.info("====================> 执行了 public void before() 方法");
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = context.getBean("jdbcSingerDao", SingerDao.class);
        Assert.assertNotNull(singerDao);
    }

    @Test
    public void test() throws ParseException {
        Singer singer = new Singer();
        singer.setFirstName("L");
        singer.setLastName("HM");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-08-20"));
        singerDao.insert(singer);
        LOGGER.info("==================> 测试方法执行完成，singer: [{}]", singer);
    }

    @After
    public void after() {
        LOGGER.info("====================> 执行了 public void after() 方法");
        if (context != null) {
            context.close();
        }
    }
}
