package com.zgy.study.spring5.transactions.jta;

import com.zgy.study.spring5.transactions.jta.config.ServicesConfig;
import com.zgy.study.spring5.transactions.jta.config.XAJpaConfig;
import com.zgy.study.spring5.transactions.jta.entity.Singer;
import com.zgy.study.spring5.transactions.jta.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ZGY <br>
 * @date 2019/11/18 12:11 <br>
 * @description TransactionsJtaApplication <br>
 */
public class TransactionsJtaApplication {

    private static Logger logger = LoggerFactory.getLogger(TransactionsJtaApplication.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class, XAJpaConfig.class);
        SingerService singerService = ctx.getBean(SingerService.class);
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(new GregorianCalendar(1977, 9, 16).getTime().getTime()));
        singerService.save(singer);
        if (singer.getId() != null) {
            logger.info("--> Singer saved successfully");
        } else {
            logger.info("--> Singer was not saved, check the configuration!!");
        }

        ctx.close();
    }
}
