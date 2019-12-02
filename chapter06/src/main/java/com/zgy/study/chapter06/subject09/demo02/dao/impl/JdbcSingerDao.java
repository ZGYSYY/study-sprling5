package com.zgy.study.chapter06.subject09.demo02.dao.impl;

import com.zgy.study.chapter06.subject09.demo02.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

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
    public String findNameById(Long id) {
        Map<String, Object> paramMap = new HashMap<>(6);
        paramMap.put("singerId", id);
        String result = jdbcTemplate.queryForObject("select first_name || ' ' || last_name from singer where id = :singerId", paramMap, String.class);
        LOGGER.info("==================> result: [{}]", result);
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("======================> 执行了 public void afterPropertiesSet() throws Exception 方法");
    }
}
