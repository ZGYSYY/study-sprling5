package com.zgy.study.chapter06.subject09.demo02;

import com.zgy.study.chapter06.subject09.demo02.config.EmbeddedJdbcConfig;
import com.zgy.study.chapter06.subject09.demo02.dao.SingerDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:55 <br>
 * @description AppTest <br>
 */
public class AppTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        SingerDao singerDao = context.getBean("singerDao", SingerDao.class);
        Assert.assertNotNull(singerDao);
        String name = singerDao.findNameById(2L);
        Assert.assertTrue("Eric Clapton".equals(name));
    }
}
