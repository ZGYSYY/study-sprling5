package com.zgy.study.chapter07.subject08;

import com.zgy.study.chapter07.subject08.config.AdvancedConfig;
import com.zgy.study.chapter07.subject08.config.DBInitializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZGY <br/>
 * @date 2019/12/3 15:18 <br/>
 * @description AppTest <br/>
 */
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    private AnnotationConfigApplicationContext context = null;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(AdvancedConfig.class);
    }

    @Test
    public void test1() {
        DBInitializer initializer = context.getBean("dBInitializer", DBInitializer.class);
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
