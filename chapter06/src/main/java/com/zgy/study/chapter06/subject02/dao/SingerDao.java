package com.zgy.study.chapter06.subject02.dao;

import com.zgy.study.chapter06.subject02.entities.Singer;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/28 16:55 <br>
 * @description SingerDao <br>
 */
public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Singer singer);
    void update(Singer singer);
    void delete(Long id);
    List<Singer> findAllWithDetail();
    void insertWithDetail(Singer singer);
}
