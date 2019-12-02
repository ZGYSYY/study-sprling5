package com.zgy.study.chapter06.subject10.demo01;

import com.zgy.study.chapter06.subject10.demo01.config.EmbeddedJdbcConfig;
import com.zgy.study.chapter06.subject10.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject10.demo01.entities.Album;
import com.zgy.study.chapter06.subject10.demo01.entities.Singer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:55 <br>
 * @description AppTest <br>
 */
public class AppTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        SingerDao singerDao = context.getBean("singerDao", SingerDao.class);
        Assert.assertNotNull(singerDao);
        List<Singer> singerList = singerDao.findAll();
        Assert.assertTrue(singerList.size() == 3);

        singerList.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("-------" + album);
                }
            }
        });
    }
}
