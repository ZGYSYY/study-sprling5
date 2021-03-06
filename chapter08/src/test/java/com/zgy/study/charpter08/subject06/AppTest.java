package com.zgy.study.charpter08.subject06;

import com.zgy.study.chapter08.subject06.config.AppConfig;
import com.zgy.study.chapter08.subject06.entities.Album;
import com.zgy.study.chapter08.subject06.entities.Instrument;
import com.zgy.study.chapter08.subject06.entities.Singer;
import com.zgy.study.chapter08.subject06.service.SingerService;
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
    public void test() {
        List<Singer> singerList = singerService.findAllByNativeQuery();
        for (Singer singer : singerList) {
            LOGGER.info("singer: [{}]", singer);
        }
    }

    @Test
    public void test2() {
        List<Singer> singerList = singerService.findByCriteriaQuery("John", "Mayer");
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

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
