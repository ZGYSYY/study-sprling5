package com.zgy.study.chapter07.subject08.dao.impl;

import com.zgy.study.chapter07.subject08.dao.InstrumentDao;
import com.zgy.study.chapter07.subject08.entities.Instrument;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ZGY <br/>
 * @date 2019/12/4 13:56 <br/>
 * @description InstrumentDaoImpl <br/>
 */
@Repository
@Transactional
public class InstrumentDaoImpl implements InstrumentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Instrument save(Instrument instrument) {
        sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        return instrument;
    }
}
