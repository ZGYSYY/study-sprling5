package com.zgy.study.chapter09to2.subject06.service;

import com.zgy.study.chapter09to2.subject06.entity.Singer;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 17:18 <br/>
 * @description SingerService <br/>
 */
public interface SingerService {

    Singer save(Singer singer);

    List<Singer> findAll();

    Singer findById(Long id);

    Singer saveInJTA(Singer singer);
}
