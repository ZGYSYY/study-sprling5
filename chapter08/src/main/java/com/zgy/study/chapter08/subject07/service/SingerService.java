package com.zgy.study.chapter08.subject07.service;

import com.zgy.study.chapter08.subject07.entity.Singer;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 9:56 <br/>
 * @description SingerService <br/>
 */
public interface SingerService {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
