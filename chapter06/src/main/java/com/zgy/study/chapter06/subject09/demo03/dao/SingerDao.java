package com.zgy.study.chapter06.subject09.demo03.dao;

import com.zgy.study.chapter06.subject09.demo03.entities.Singer;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/29 16:55 <br>
 * @description SingerDao <br>
 */
public interface SingerDao {

    List<Singer> findAll();
}
