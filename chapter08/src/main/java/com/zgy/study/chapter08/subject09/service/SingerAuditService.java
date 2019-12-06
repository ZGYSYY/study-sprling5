package com.zgy.study.chapter08.subject09.service;

import com.zgy.study.chapter08.subject09.entity.SingerAudit;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 11:15 <br/>
 * @description SingerAuditService <br/>
 */
public interface SingerAuditService {

    List<SingerAudit> findAll();

    SingerAudit findById(Long id);

    SingerAudit save(SingerAudit singerAudit);
}
