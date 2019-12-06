package com.zgy.study.chapter08.subject07.service.impl;

import com.google.common.collect.Lists;
import com.zgy.study.chapter08.subject07.dao.SingerRepository;
import com.zgy.study.chapter08.subject07.entity.Singer;
import com.zgy.study.chapter08.subject07.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 10:13 <br/>
 * @description SingerServiceImpl <br/>
 */
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return singerRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
