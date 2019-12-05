package com.zgy.study.chapter08.subject06.service.impl;

import com.zgy.study.chapter08.subject06.entities.Singer_;
import com.zgy.study.chapter08.subject06.entities.Singer;
import com.zgy.study.chapter08.subject06.service.SingerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 16:46 <br/>
 * @description SingerServiceImpl <br/>
 */
@Service
public class SingerServiceImpl implements SingerService {

    private static final String FIND_ALL_BY_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllByNativeQuery() {
        return entityManager.createNativeQuery(FIND_ALL_BY_NATIVE_QUERY, "singerResult").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findByCriteriaQuery(String firstName, String lastName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Singer> query = criteriaBuilder.createQuery(Singer.class);
        Root<Singer> singerRoot = query.from(Singer.class);
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);

        query.select(singerRoot).distinct(true);
        Predicate predicate = criteriaBuilder.conjunction();

        if (firstName != null) {
            Predicate equal = criteriaBuilder.equal(singerRoot.get(Singer_.firstName), firstName);
            predicate = criteriaBuilder.and(predicate, equal);
        }
        if (lastName != null) {
            Predicate equal = criteriaBuilder.equal(singerRoot.get(Singer_.lastName), lastName);
            predicate = criteriaBuilder.and(predicate, equal);
        }

        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
}
