package com.zgy.study.spring5.base.dao;

import com.zgy.study.spring5.base.dao.config.DataJpaConfig;
import com.zgy.study.spring5.base.dao.config.ServicesConfig;
import com.zgy.study.spring5.base.dao.service.SingerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author ZGY <br>
 * @date 2019/11/14 17:12 <br>
 * @description BaseDaoApplication3，使用编程式事务 <br>
 */
public class BaseDaoApplication3 {

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class, DataJpaConfig.class);
        SingerService singerService = context.getBean(SingerService.class);
        System.out.println("Singer count: " + singerService.countAll());
        context.close();
    }
}
