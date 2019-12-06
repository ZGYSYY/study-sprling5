package com.zgy.study.charpter08.subject09;

import com.zgy.study.chapter08.subject09.config.DataJpaConfig;
import com.zgy.study.chapter08.subject09.entity.Album;
import com.zgy.study.chapter08.subject09.entity.Singer;
import com.zgy.study.chapter08.subject09.entity.SingerAudit;
import com.zgy.study.chapter08.subject09.service.AlbumService;
import com.zgy.study.chapter08.subject09.service.SingerAuditService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 14:03 <br/>
 * @description AppTest <br/>
 */
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    private AnnotationConfigApplicationContext context;

    private AlbumService albumService;

    private SingerAuditService singerAuditService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        albumService = context.getBean("albumServiceImpl", AlbumService.class);
        singerAuditService = context.getBean("singerAuditServiceImpl", SingerAuditService.class);
    }

    @Test
    public void test() {
        Singer singer = new Singer();
        singer.setId(1L);
        List<Album> albumList = albumService.findBySinger(singer);
        for (Album album : albumList) {
            LOGGER.info("album: [{}]", album);
        }
    }

    @Test
    public void test2() {
        List<Album> albumList = albumService.findByTitle("Search");
        for (Album album : albumList) {
            LOGGER.info("album: [{}]", album);
        }
    }

    @Test
    public void test3() throws ParseException, InterruptedException {
        List<SingerAudit> singerAuditList = singerAuditService.findAll();
        for (SingerAudit singerAudit : singerAuditList) {
            LOGGER.info("singerAudit: [{}]", singerAudit);
        }

        SingerAudit singerAudit = new SingerAudit();
        singerAudit.setFirstName("BB");
        singerAudit.setLastName("King");
        singerAudit.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1940-09-20"));

        singerAuditService.save(singerAudit);

        singerAuditList = singerAuditService.findAll();
        for (SingerAudit singerAudit2 : singerAuditList) {
            LOGGER.info("singerAudit2: [{}]", singerAudit2);
        }

        TimeUnit.SECONDS.sleep(2);

        singerAudit = singerAuditService.findById(1L);
        singerAudit.setFirstName("ZGY");
        singerAuditService.save(singerAudit);

        singerAuditList = singerAuditService.findAll();
        for (SingerAudit singerAudit3 : singerAuditList) {
            LOGGER.info("singerAudit3: [{}]", singerAudit3);
        }
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
