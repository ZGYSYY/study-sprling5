package com.zgy.study.chapter06.subject12.demo01;

import com.zgy.study.chapter06.subject12.demo01.config.AppConfig;
import com.zgy.study.chapter06.subject12.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject12.demo01.entities.Singer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    public void test() {
        List<Singer> singerList = singerDao.findAll();
        Assert.assertTrue(singerList.size() == 3);
        singerList.forEach(x -> {
            System.out.println(x);
        });
    }

    @Test
    public void test2() {
        List<Singer> singerList = singerDao.findByFirstName("John");
        Assert.assertTrue(singerList.size() >= 0);
        singerList.forEach(x -> {
            System.out.println(x);
        });
    }

    @After
    public void after() {
        LOGGER.info("====================> 执行了 public void after() 方法");
        if (context != null) {
            context.close();
        }
    }
}
