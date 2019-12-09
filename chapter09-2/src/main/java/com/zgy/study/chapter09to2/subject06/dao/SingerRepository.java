package com.zgy.study.chapter09to2.subject06.dao;

import com.zgy.study.chapter09to2.subject06.entity.Singer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ZGY <br/>
 * @date 2019/12/9 10:46 <br/>
 * @description SingerRepository <br/>
 */
public interface SingerRepository extends CrudRepository<Singer, Long> {


}
