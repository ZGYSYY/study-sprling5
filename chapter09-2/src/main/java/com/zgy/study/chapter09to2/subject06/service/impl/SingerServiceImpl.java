package com.zgy.study.chapter09to2.subject06.service.impl;

import com.zgy.study.chapter09to2.subject06.entity.Singer;
import com.zgy.study.chapter09to2.subject06.service.SingerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 17:39 <br/>
 * @description SingerServiceImpl <br/>
 */
@Service
public class SingerServiceImpl implements SingerService {

    @PersistenceContext(unitName = "emfA")
    private EntityManager entityManagerA;

    @PersistenceContext(unitName = "emfB")
    private EntityManager entityManagerB;

    @Override
    public Singer save(Singer singer) {
        Singer singer2 = new Singer();
        singer2.setFirstName("L");
        singer2.setLastName("HM");
        if (singer.getId() == null) {
            entityManagerA.persist(singer);
            entityManagerB.persist(singer2);
        } else {
            entityManagerA.merge(singer);
            entityManagerB.merge(singer2);
        }
        return singer;
    }
}
