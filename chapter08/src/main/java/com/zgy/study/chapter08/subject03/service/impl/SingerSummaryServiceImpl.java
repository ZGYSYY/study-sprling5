package com.zgy.study.chapter08.subject03.service.impl;

import com.zgy.study.chapter08.subject03.service.SingerSummaryService;
import com.zgy.study.chapter08.subject03.view.SingerSummary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 15:27 <br/>
 * @description SingerSummaryServiceImpl <br/>
 */
@Service
@Transactional
public class SingerSummaryServiceImpl implements SingerSummaryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<SingerSummary> findAll() {
        List result = entityManager.createQuery("select new com.zgy.study.chapter08.subject03.view.SingerSummary(s.firstName, s.lastName, a.title) from Singer s " +
                "left join s.albums a where a.releaseDate = (select max(a2.releaseDate) from Album a2 where a2.singer.id = s.id)").getResultList();
        return result;
    }
}
