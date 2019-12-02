package com.zgy.study.chapter06.subject12.demo01.dao.impl;

import com.zgy.study.chapter06.subject12.demo01.FindByFirstName;
import com.zgy.study.chapter06.subject12.demo01.SelectAllSingers;
import com.zgy.study.chapter06.subject12.demo01.UpdateSinger;
import com.zgy.study.chapter06.subject12.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject12.demo01.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private SelectAllSingers selectAllSingers;

    private FindByFirstName findByFirstName;

    private UpdateSinger updateSinger;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllSingers(dataSource);
        this.findByFirstName = new FindByFirstName(dataSource);
        this.updateSinger = new UpdateSinger(dataSource);
    }

    @Override
    public List<Singer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public List<Singer> findByFirstName(String firsName) {
        Map<String, String> paramMap = new HashMap<>(16);
        paramMap.put("firstName", firsName);
        return findByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public void update(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("firstName", singer.getFirstName());
        paramMap.put("lastName", singer.getLastName());
        paramMap.put("birthDate", singer.getBirthDate());
        paramMap.put("id", singer.getId());
        updateSinger.updateByNamedParam(paramMap);
        LOGGER.info("=============> singer 更新成功，id 为：[{}]", singer.getId());
    }
}
