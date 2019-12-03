package com.zgy.study.chapter07.subject04;

import com.zgy.study.chapter07.subject04.entities.Album;
import com.zgy.study.chapter07.subject04.entities.Instrument;
import com.zgy.study.chapter07.subject04.entities.Singer;
import com.zgy.study.chapter07.subject04.config.AppConfig;
import com.zgy.study.chapter07.subject04.dao.SingerDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void test1() {
        LOGGER.info("==================> 执行 public void test1() 方法 =========> GO");
        SingerDao singerDao = context.getBean("singerDaoImpl", SingerDao.class);
        List<Singer> singerList = singerDao.findAll();
        for (Singer singer : singerList) {
            LOGGER.info("singer: [{}]", singer);
            if (!singer.getAlbums().isEmpty()) {
                for (Album album : singer.getAlbums()) {
                    LOGGER.info("== album: [{}]", album);
                }
            }
            if (!singer.getInstruments().isEmpty()) {
                for (Instrument instrument : singer.getInstruments()) {
                    LOGGER.info("== instrument: [{}]", instrument);
                }
            }
        }
        LOGGER.info("==================> 执行 public void test1() 方法 =========> END");
    }

    @Test
    public void test2() {
        SingerDao singerDao = context.getBean("singerDaoImpl", SingerDao.class);
        List<Singer> singerList = singerDao.findAllWithAlbum();
        if (singerList != null) {
            LOGGER.info("===================> 打印数据");
            for (Singer singer : singerList) {
                LOGGER.info("singer: [{}]", singer);
                if (!singer.getAlbums().isEmpty()) {
                    for (Album album : singer.getAlbums()) {
                        LOGGER.info("== album: [{}]", album);
                    }
                }
            }
        }
    }

    @Test
    public void test3() {
        SingerDao singerDao = context.getBean("singerDaoImpl", SingerDao.class);
        Singer singer = singerDao.findById(1L);
        LOGGER.info("singer: [{}]", singer);
        if (!singer.getAlbums().isEmpty()) {
            for (Album album : singer.getAlbums()) {
                LOGGER.info("== album: [{}]", album);
            }
        }
        if (!singer.getInstruments().isEmpty()) {
            for (Instrument instrument : singer.getInstruments()) {
                LOGGER.info("== instrument: [{}]", instrument);
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
