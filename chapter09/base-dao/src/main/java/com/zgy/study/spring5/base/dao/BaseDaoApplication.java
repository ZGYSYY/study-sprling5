package com.zgy.study.spring5.base.dao;

import com.zgy.study.spring5.base.dao.config.DataJpaConfig;
import com.zgy.study.spring5.base.dao.config.ServicesConfig;
import com.zgy.study.spring5.base.dao.entity.Singer;
import com.zgy.study.spring5.base.dao.service.SingerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/14 17:12 <br>
 * @description BaseDaoApplication，使用声明式事务 <br>
 */
public class BaseDaoApplication {

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class, DataJpaConfig.class);
        SingerService singerService = context.getBean(SingerService.class);
        List<Singer> singerList = singerService.findAll();
        singerList.forEach(s -> System.out.println(s));

        Singer singer = singerService.findById(1L);
        singer.setFirstName("Z");
        singer.setLastName("GY");
        singerService.save(singer);
        System.out.println("歌手数据保存成功：" + singer);

        System.out.println("歌手总数为：" + singerService.countAll());
        context.close();
    }
}
