package com.zgy.study.chapter08.subject02.service.impl;

import com.zgy.study.chapter08.subject02.entities.Singer;
import com.zgy.study.chapter08.subject02.service.SingerService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 11:18 <br/>
 * @description SingerDaoImpl <br/>
 */
@Transactional
@Repository
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
        throw new NotImplementedException("save");
    }

    @Override
    public void delete(Singer singer) {
        throw new NotImplementedException("delete");
    }

    @Override
    public List<Singer> findAllByNativeQuery() {
        throw new NotImplementedException("findAllByNativeQuery");
    }

    /**
     * 查询非类型化结果
     */
    @Transactional(readOnly = true)
    public void displayAllSingerSummary() {
        List result = entityManager.createQuery("select s.firstName, s.lastName, a.title from Singer s " +
                "left join s.albums a where a.releaseDate = (select max(a2.releaseDate) from Album a2 " +
                "where a2.singer.id = s.id)").getResultList();
        int count = 0;
        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
            Object[] values = (Object[]) iterator.next();
            LOGGER.info("[{}]: [{}], [{}], [{}]", ++count, values[0], values[1], values[2]);
        }
    }
}
