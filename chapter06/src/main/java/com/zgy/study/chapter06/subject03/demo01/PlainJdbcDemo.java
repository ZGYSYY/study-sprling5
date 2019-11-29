package com.zgy.study.chapter06.subject03.demo01;

import com.zgy.study.chapter06.subject03.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject03.demo01.dao.impl.PlainSingerDao;
import com.zgy.study.chapter06.subject03.demo01.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/29 11:51 <br>
 * @description PlainJdbcDemo <br>
 */
public class PlainJdbcDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlainJdbcDemo.class);

    private static SingerDao singerDao = new PlainSingerDao();

    public static void main(String[] args) {
        LOGGER.info("Listing initial singer data:");
        listAllSingers();

        LOGGER.info("Insert a new singer");
        Singer singer = new Singer();
        singer.setFirstName("Z");
        singer.setLastName("GY");
        try {
            singer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1996-11-18"));
        } catch (ParseException e) {
            LOGGER.error("字符串转日期错误", e);
        }
        singerDao.insert(singer);

        LOGGER.info("Listing singer data after new singer created:");
        listAllSingers();

        LOGGER.info("Delete the previous created singer");
        singerDao.delete(singer.getId());

        LOGGER.info("Listing singer data after new singer deleted:");
        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singerList = singerDao.findAll();
        for (Singer singer : singerList) {
            System.out.println(singer);
        }
    }
}
