package com.zgy.study.chapter08.subject09.service.impl;

import com.google.common.collect.Lists;
import com.zgy.study.chapter08.subject09.dao.SingerAuditRepository;
import com.zgy.study.chapter08.subject09.entity.SingerAudit;
import com.zgy.study.chapter08.subject09.service.SingerAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 11:16 <br/>
 * @description SingerAuditServiceImpl <br/>
 */
@Service
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).get();
    }

    @Override
    @Transactional
    public SingerAudit save(SingerAudit singerAudit) {
        return singerAuditRepository.save(singerAudit);
    }
}
