package com.zgy.study.chapter08.subject03.service.impl;

import com.zgy.study.chapter08.subject03.entities.Singer;
import com.zgy.study.chapter08.subject03.service.SingerService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 11:18 <br/>
 * @description SingerDaoImpl <br/>
 */
@Transactional
@Service
public class SingerServiceImpl implements SingerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerServiceImpl.class);

    private static final String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
         return entityManager.createNamedQuery(Singer.FIND_ALL).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return entityManager.createNamedQuery(Singer.FIND_ALL_WITH_ALBUM).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return entityManager.createNamedQuery(Singer.FIND_BY_ID, Singer.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Singer save(Singer singer) {
        if (singer.getId() == null) {
            entityManager.persist(singer);
        } else {
            entityManager.merge(singer);
        }
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        Singer merge = entityManager.merge(singer);
        entityManager.remove(merge);
    }

    @Override
    public List<Singer> findAllByNativeQuery() {
        throw new NotImplementedException("findAllByNativeQuery");
    }
}
