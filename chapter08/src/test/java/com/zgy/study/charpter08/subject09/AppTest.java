package com.zgy.study.charpter08.subject09;

import com.zgy.study.chapter08.subject09.config.DataJpaConfig;
import com.zgy.study.chapter08.subject09.entity.Album;
import com.zgy.study.chapter08.subject09.entity.Singer;
import com.zgy.study.chapter08.subject09.service.AlbumService;
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

    private AlbumService albumService;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        albumService = context.getBean("albumServiceImpl", AlbumService.class);
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
    public void test2 () {
        List<Album> albumList = albumService.findByTitle("Search");
        for (Album album : albumList) {
            LOGGER.info("album: [{}]", album);
        }
    }

    @After
    public void after() {
        if (context != null) {
            context.close();
        }
    }
}
