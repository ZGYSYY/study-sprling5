package com.zgy.study.charpter08.subject02;

import com.zgy.study.chapter08.subject02.config.AppConfig;
import com.zgy.study.chapter08.subject02.entities.Album;
import com.zgy.study.chapter08.subject02.entities.Instrument;
import com.zgy.study.chapter08.subject02.entities.Singer;
import com.zgy.study.chapter08.subject02.service.SingerService;
import com.zgy.study.chapter08.subject02.service.impl.SingerServiceImpl;
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
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        singerService = context.getBean("singerServiceImpl", SingerService.class);
    }

    @Test
    public void test1() {
        List<Singer> singerList = singerService.findAll();
        for (Singer singer : singerList) {
            LOGGER.info("singer: [{}]", singer);
        }
    }

    @Test
    public void test2() {
        List<Singer> singerList = singerService.findAllWithAlbum();
        for (Singer singer : singerList) {
            LOGGER.info("singer: [{}]", singer);
            if (!singer.getAlbums().isEmpty()) {
                for (Album album : singer.getAlbums()) {
                    LOGGER.info("==> album: [{}]", album);
                }
            }
            if (!singer.getInstruments().isEmpty()) {
                for (Instrument instrument : singer.getInstruments()) {
                    LOGGER.info("==> instrument: [{}]", instrument);
                }
            }
        }
    }

    @Test
    public void test3() {
        Singer singer = singerService.findById(1L);
        LOGGER.info("singer: [{}]", singer);
        if (!singer.getAlbums().isEmpty()) {
            for (Album album : singer.getAlbums()) {
                LOGGER.info("==> album: [{}]", album);
            }
        }
        if (!singer.getInstruments().isEmpty()) {
            for (Instrument instrument : singer.getInstruments()) {
                LOGGER.info("==> instrument: [{}]", instrument);
            }
        }
    }

    @Test
    public void test4() {
        SingerServiceImpl singerService = context.getBean("singerServiceImpl", SingerServiceImpl.class);
        singerService.displayAllSingerSummary();
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
