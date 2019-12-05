package com.zgy.study.chapter08.subject06.service;

import com.zgy.study.chapter08.subject06.entities.Singer;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 16:46 <br/>
 * @description SingerService <br/>
 */
public interface SingerService {

    List<Singer> findAllByNativeQuery();

    List<Singer> findByCriteriaQuery(String firstName, String lastName);
}
