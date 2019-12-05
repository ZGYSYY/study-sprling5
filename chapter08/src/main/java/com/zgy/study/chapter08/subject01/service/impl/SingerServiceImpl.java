package com.zgy.study.chapter08.subject01.service.impl;

import com.zgy.study.chapter08.subject01.service.SingerService;
import com.zgy.study.chapter08.subject01.entities.Singer;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 11:18 <br/>
 * @description SingerDaoImpl <br/>
 */
@Transactional
@Repository
@Service
public class SingerServiceImpl implements SingerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerServiceImpl.class);

    private static final String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        throw new NotImplementedException("findAll");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        throw new NotImplementedException("findAllWithAlbum");
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        throw new NotImplementedException("findById");
    }

    @Override
    public Singer save(Singer singer) {
        throw new NotImplementedException("save");
    }

    @Override
    public void delete(Singer singer) {
        throw new NotImplementedException("delete");
    }

    @Override
    public List<Singer> findAllByNativeQuery() {
        throw new NotImplementedException("findAllByNativeQuery");
    }
}
