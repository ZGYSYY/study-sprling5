package com.zgy.study.spring5.base.dao.service.impl;

import com.google.common.collect.Lists;
import com.zgy.study.spring5.base.dao.entity.Singer;
import com.zgy.study.spring5.base.dao.repos.SingerRepository;
import com.zgy.study.spring5.base.dao.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @author ZGY <br>
 * @date 2019/11/14 16:57 <br>
 * @description SingerServiceImpl <br>
 */
@Service
@Transactional
public class SingerServiceImpl implements SingerService {

    private SingerRepository singerRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public void setSingerRepository(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    /**
     * 获取全部歌手列表
     *
     * @return
     */
    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    /**
     * 根据 Id 查询歌手
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        Optional<Singer> s = singerRepository.findById(id);
        if (s != null && s.isPresent()) {
            return s.get();
        }
        return new Singer();
    }

    /**
     * 保存歌手
     *
     * @param singer
     * @return
     */
    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    /**
     * 获取歌手总数量
     *
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Long countAll() {
//        return singerRepository.countAllSingers();
        // 使用编程式事务
        return transactionTemplate.execute(transactionStatus -> entityManager.createNamedQuery(Singer.COUNT_ALL, Long.class).getSingleResult());
    }
}
