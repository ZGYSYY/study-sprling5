package com.zgy.study.chapter08.subject10.service.impl;

import com.google.common.collect.Lists;
import com.zgy.study.chapter08.subject10.dao.SingerAuditRepository;
import com.zgy.study.chapter08.subject10.entity.SingerAudit;
import com.zgy.study.chapter08.subject10.service.SingerAuditService;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;

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
    @Transactional(rollbackFor = Exception.class)
    public SingerAudit save(SingerAudit singerAudit) {
        return singerAuditRepository.save(singerAudit);
    }

    @Override
    @Transactional(readOnly = true)
    public SingerAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(SingerAudit.class, id, revision);
    }
}
