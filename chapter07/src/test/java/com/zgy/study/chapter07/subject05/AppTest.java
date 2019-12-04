package com.zgy.study.chapter07.subject05;

import com.zgy.study.chapter07.subject05.config.AppConfig;
import com.zgy.study.chapter07.subject05.dao.SingerDao;
import com.zgy.study.chapter07.subject05.entities.Album;
import com.zgy.study.chapter07.subject05.entities.Instrument;
import com.zgy.study.chapter07.subject05.entities.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    public void test4() throws ParseException {
        SingerDao singerDao = context.getBean("singerDaoImpl", SingerDao.class);

        Singer singer = new Singer();
        singer.setFirstName("Z");
        singer.setLastName("GY");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));

        Set<Album> albums = new LinkedHashSet<>(2);
        Album album = new Album();
        album.setTitle("AAAAAAAAAAAAAA");
        album.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-19"));
        album.setSinger(singer);
        albums.add(album);
        album = new Album();
        album.setTitle("BBBBBBBBBBBBBB");
        album.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-20"));
        album.setSinger(singer);
        albums.add(album);
        singer.setAlbums(albums);

        Set<Instrument> instruments = new LinkedHashSet<>(1);
        Instrument instrument = new Instrument();
        instrument.setInstrumentId("Piano");
        instruments.add(instrument);
        singer.setInstruments(instruments);
        singer = singerDao.save(singer);

        LOGGER.info("singer: [{}]", singer);

        if (singer.getId() != null) {
            singer = singerDao.findById(singer.getId());
            LOGGER.info("singer: [{}]", singer);
            if (!singer.getAlbums().isEmpty()) {
                for (Album singerAlbum : singer.getAlbums()) {
                    LOGGER.info("==> singerAlbum: [{}]", singerAlbum);
                }
            }
            if (!singer.getInstruments().isEmpty()) {
                for (Instrument singerInstrument : singer.getInstruments()) {
                    LOGGER.info("==> singerInstrument: [{}]", singerInstrument);
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
