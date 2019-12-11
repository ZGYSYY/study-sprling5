package com.zgy.study.chapter16.subject03.service;

import com.zgy.study.chapter16.subject03.entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZGY
 * @date 2019/12/11 16:13
 * @description SingerServiceImpl
 */
@Service
public class SingerServiceImpl implements SingerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerServiceImpl.class);

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>(2);
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("Z");
        singer.setLastName("GY");
        singer.setAge(23);
        singer.setPhone("88888888");
        result.add(singer);
        singer = new Singer();
        singer.setId(2L);
        singer.setFirstName("L");
        singer.setLastName("HM");
        singer.setAge(24);
        singer.setPhone("66666666");
        result.add(singer);
        return result;
    }
}
