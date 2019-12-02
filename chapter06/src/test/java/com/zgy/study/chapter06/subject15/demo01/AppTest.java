package com.zgy.study.chapter06.subject15.demo01;

import com.zgy.study.chapter06.subject15.demo01.config.AppConfig;
import com.zgy.study.chapter06.subject15.demo01.dao.SingerDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.text.ParseException;

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
        String firstName = singerDao.findFirstNameById(2L);
        LOGGER.info("==================> 测试方法执行完成，firstName: [{}]", firstName);
    }

    @After
    public void after() {
        LOGGER.info("====================> 执行了 public void after() 方法");
        if (context != null) {
            context.close();
        }
    }
}
