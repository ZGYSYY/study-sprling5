package com.zgy.study.chapter16.subject03.service;

import com.zgy.study.chapter16.subject03.entity.Singer;

import java.util.List;

/**
 * @author ZGY
 * @date 2019/12/11 16:10
 * @description SingerService
 */
public interface SingerService {

    List<Singer> findAll();
}
