package com.zgy.study.spring5.transactions.jta.services.impl;

import com.zgy.study.spring5.transactions.jta.entity.Singer;
import com.zgy.study.spring5.transactions.jta.services.SingerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ZGY <br>
 * @date 2019/11/18 14:34 <br>
 * @description SingerServiceImpl <br>
 */
@Service
@Transactional
public class SingerServiceImpl implements SingerService {

    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;

    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    /**
     * 保存歌手
     *
     * @param singer
     * @return
     */
    @Override
    public Singer save(Singer singer) {
        Singer singerB = new Singer();
        singerB.setFirstName(singer.getFirstName());
        singerB.setLastName(singer.getLastName());
        if (singer.getId() == null) {
            emA.persist(singer);
            emB.persist(singerB);
        } else {
            emA.merge(singer);
            emB.merge(singer);
        }
        return singer;
    }
}
