package com.zgy.study.chapter09to2.subject06.service.impl;

import com.google.common.collect.Lists;
import com.zgy.study.chapter09to2.subject06.dao.SingerRepository;
import com.zgy.study.chapter09to2.subject06.entity.Singer;
import com.zgy.study.chapter09to2.subject06.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 17:39 <br/>
 * @description SingerServiceImpl <br/>
 */
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @PersistenceContext(unitName = "entityManagerFactory2")
    private EntityManager entityManager2;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Singer save(Singer singer) {
        singerRepository.save(singer);
        return singer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return singerRepository.findById(id).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Singer saveInJTA(Singer singer) {
        Singer singer2 = new Singer();
        singer2.setFirstName(singer.getFirstName());
        singer2.setLastName(singer.getLastName());
        singer2.setBirthDate(singer.getBirthDate());
        if (singer.getId() == null) {
            entityManager.persist(singer);
            entityManager2.persist(singer2);
        } else {
            entityManager.merge(singer);
            entityManager2.merge(singer);
        }
        return singer;
    }
}
