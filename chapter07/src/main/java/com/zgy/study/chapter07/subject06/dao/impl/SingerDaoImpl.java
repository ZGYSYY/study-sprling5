package com.zgy.study.chapter07.subject06.dao.impl;

import com.zgy.study.chapter07.subject06.dao.SingerDao;
import com.zgy.study.chapter07.subject06.entities.Singer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/3 14:55 <br/>
 * @description SingerDaoImpl <br/>
 */
@Repository
@Transactional
public class SingerDaoImpl implements SingerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @Transactional(readOnly = true)：将事务设置为只读 <br/>
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        List<Singer> result = sessionFactory.getCurrentSession().createQuery("select s from Singer s", Singer.class).list();
        return result;
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        // 用法一
        return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
        // 用法二
        // return sessionFactory.getCurrentSession().createQuery("select distinct s from Singer s left join fetch s.albums a left join fetch s.instruments i").list();
    }

    @Override
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession().getNamedQuery("Singer.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    public Singer save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        return singer;
    }

    @Override
    public void delete(Singer singer) {

    }
}
