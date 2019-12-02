package com.zgy.study.chapter06.subject09.demo03.dao.impl;

import com.zgy.study.chapter06.subject09.demo03.dao.SingerDao;
import com.zgy.study.chapter06.subject09.demo03.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:10 <br>
 * @description JdbcSingerDao <br>
 */
public class JdbcSingerDao implements SingerDao, InitializingBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);

    public NamedParameterJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = jdbcTemplate.query("select id, first_name, last_name, birth_date from singer", (x, y) -> {
            Singer singer = new Singer();
            singer.setId(x.getLong("id"));
            singer.setFirstName(x.getString("first_name"));
            singer.setLastName(x.getString("last_name"));
            singer.setBirthDate(x.getDate("birth_date"));
            return singer;
        });
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("======================> 执行了 public void afterPropertiesSet() throws Exception 方法");
        if (jdbcTemplate == null) {
            throw new BeanCreationException("jdbcTemplate 为空");
        }
    }
}
