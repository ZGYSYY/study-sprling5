package com.zgy.study.charpter08.subject10;

import com.zgy.study.chapter08.subject10.config.DataJpaConfig;
import com.zgy.study.chapter08.subject10.entity.SingerAudit;
import com.zgy.study.chapter08.subject10.service.SingerAuditService;
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
 * @date 2019/12/5 14:03 <br/>
 * @description AppTest <br/>
 */
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    private AnnotationConfigApplicationContext context;

    private SingerAuditService singerAuditService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        singerAuditService = context.getBean("singerAuditServiceImpl", SingerAuditService.class);
    }

    @Test
    public void test() throws ParseException {
        SingerAudit singerAudit = new SingerAudit();
        singerAudit.setFirstName("BB");
        singerAudit.setLastName("King");
        singerAudit.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-08-20"));

        singerAuditService.save(singerAudit);
        listSingers("NO1");

        singerAudit.setFirstName("ZGY");
        singerAuditService.save(singerAudit);
        listSingers("NO2");

        SingerAudit oldSingerAudit = singerAuditService.findAuditByRevision(1L, 1);
        LOGGER.info("oldSingerAudit: [{}]", oldSingerAudit);
    }

    private void listSingers(String prefix) {
        List<SingerAudit> singerAuditList = singerAuditService.findAll();
        for (SingerAudit singerAudit : singerAuditList) {
            LOGGER.info("singerAudit-[{}]: [{}]", prefix, singerAudit);
        }
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
