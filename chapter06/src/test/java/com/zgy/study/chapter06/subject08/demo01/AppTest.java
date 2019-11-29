package com.zgy.study.chapter06.subject08.demo01;

import com.zgy.study.chapter06.subject08.demo01.config.EmbeddedJdbcConfig;
import com.zgy.study.chapter06.subject08.demo01.dao.SingerDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/29 17:27 <br>
 * @description AppTest <br>
 */
public class AppTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void test1() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);

        SingerDao singerDao = context.getBean("singerDao", SingerDao.class);
        String name = singerDao.findNameById(1L);
        LOGGER.info("=============> name: [{}]", name);
    }
}
