package com.zgy.study.chapter06.subject15.demo01.dao.impl;

import com.zgy.study.chapter06.subject15.demo01.StoredFunctionFirstNameById;
import com.zgy.study.chapter06.subject15.demo01.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:10 <br>
 * @description JdbcSingerDao <br>
 */
@Repository
public class JdbcSingerDao implements SingerDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);

    private DataSource dataSource;

    private StoredFunctionFirstNameById storedFunctionFirstNameById;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.storedFunctionFirstNameById = new StoredFunctionFirstNameById(dataSource);
    }

    @Override
    public String findFirstNameById(Long id) {
        List<String> list = storedFunctionFirstNameById.execute(id);
        String result = list.get(0);
        return result;
    }
}
