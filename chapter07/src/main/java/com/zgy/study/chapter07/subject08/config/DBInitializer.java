package com.zgy.study.chapter07.subject08.config;

import com.zgy.study.chapter07.subject08.dao.InstrumentDao;
import com.zgy.study.chapter07.subject08.dao.SingerDao;
import com.zgy.study.chapter07.subject08.entities.Album;
import com.zgy.study.chapter07.subject08.entities.Instrument;
import com.zgy.study.chapter07.subject08.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ZGY <br/>
 * @date 2019/12/4 13:51 <br/>
 * @description DBInitializer <br/>
 */
@Service("dBInitializer")
public class DBInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    private SingerDao singerDao;

    @Autowired
    private InstrumentDao instrumentDao;

    @PostConstruct
    public void initDB() throws ParseException {
        LOGGER.info("===================> 数据初始化...");
        Instrument guitar = new Instrument();
        guitar.setInstrumentId("Guitar");
        instrumentDao.save(guitar);

        Singer singer = new Singer();
        singer.setFirstName("Z");
        singer.setLastName("GY");
        singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));
        singer.getInstruments().add(guitar);

        Album album = new Album();
        album.setTitle("老子明天不上班");
        album.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2001-11-18"));
        album.setSinger(singer);

        singer.getAlbums().add(album);

        singerDao.save(singer);

        LOGGER.info("=================> 数据初始化完毕...");
    }
}
