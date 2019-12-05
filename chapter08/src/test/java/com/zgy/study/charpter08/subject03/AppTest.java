package com.zgy.study.charpter08.subject03;

import com.zgy.study.chapter08.subject03.config.AppConfig;
import com.zgy.study.chapter08.subject03.entities.Album;
import com.zgy.study.chapter08.subject03.entities.Instrument;
import com.zgy.study.chapter08.subject03.entities.Singer;
import com.zgy.study.chapter08.subject03.service.SingerService;
import com.zgy.study.chapter08.subject03.service.SingerSummaryService;
import com.zgy.study.chapter08.subject03.view.SingerSummary;
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

    private SingerSummaryService singerSummaryService;

    private SingerService singerService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        singerSummaryService = context.getBean("singerSummaryServiceImpl", SingerSummaryService.class);
        singerService = context.getBean("singerServiceImpl", SingerService.class);

    }

    @Test
    public void test() {
        List<SingerSummary> singerSummaryList = singerSummaryService.findAll();
        for (SingerSummary singerSummary : singerSummaryList) {
            LOGGER.info("singerSummary: [{}]", singerSummary);
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
    public void test3() throws ParseException {
        Singer singer = new Singer();
        singer.setFirstName("Z");
        singer.setLastName("GY");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));

        Album album = new Album();
        album.setTitle("我的世界");
        album.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2005-11-18"));
        album.setSinger(singer);
        singer.getAlbums().add(album);

        Instrument instrument = new Instrument();
        instrument.setInstrumentId("Voice");
        singer.getInstruments().add(instrument);

        singerService.save(singer);
        test2();
    }

    @Test
    public void test4() {
        Singer singer = singerService.findById(1L);
        Album album = singer.getAlbums().stream().filter(x -> x.getTitle().equals("Battle Studies")).findFirst().get();
        singer.getAlbums().remove(album);
        singer.setFirstName("L");
        singer.setLastName("HM");

        singerService.save(singer);
        test2();
    }

    @Test
    public void test5() {
        Singer singer = singerService.findById(1L);
        singerService.delete(singer);
        test2();
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
