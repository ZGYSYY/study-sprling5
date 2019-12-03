package com.zgy.study.chapter07.subject04.dao;

import com.zgy.study.chapter07.subject04.entities.Singer;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/3 14:52 <br/>
 * @description SingerDao <br/>
 */
public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
}
