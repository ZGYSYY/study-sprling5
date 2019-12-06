package com.zgy.study.chapter08.subject10.dao;

import com.zgy.study.chapter08.subject10.entity.SingerAudit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 11:17 <br/>
 * @description SingerAuditRepository <br/>
 */
public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
