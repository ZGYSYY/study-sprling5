package com.zgy.study.chapter06.subject13.demo01.dao.impl;

import com.zgy.study.chapter06.subject12.demo01.FindByFirstName;
import com.zgy.study.chapter06.subject12.demo01.SelectAllSingers;
import com.zgy.study.chapter06.subject12.demo01.UpdateSinger;
import com.zgy.study.chapter06.subject13.demo01.InsertSinger;
import com.zgy.study.chapter06.subject13.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject13.demo01.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:10 <br>
 * @description JdbcSingerDao <br>
 */
@Repository
public class JdbcSingerDao implements SingerDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);

    private DataSource dataSource;

    private InsertSinger insertSinger;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.insertSinger = new InsertSinger(dataSource);
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("firstName", singer.getFirstName());
        paramMap.put("lastName", singer.getLastName());
        paramMap.put("birthDate", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        LOGGER.info("===============> 插入数据成功，数据为：[{}]，返回的 Id 为：[{}]", singer, singer.getId());
    }
}
