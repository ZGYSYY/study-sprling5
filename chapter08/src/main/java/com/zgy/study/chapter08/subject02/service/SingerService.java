package com.zgy.study.chapter08.subject02.service;

import com.zgy.study.chapter08.subject02.entities.Singer;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/3 14:52 <br/>
 * @description SingerDao <br/>
 */
public interface SingerService {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    List<Singer> findAllByNativeQuery();
}
