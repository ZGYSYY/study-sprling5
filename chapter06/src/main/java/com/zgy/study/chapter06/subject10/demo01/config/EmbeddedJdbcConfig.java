package com.zgy.study.chapter06.subject10.demo01.config;

import com.zgy.study.chapter06.subject10.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject10.demo01.dao.impl.JdbcSingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:12 <br>
 * @description EmbeddedJdbcConfig <br>
 */
@Configuration
public class EmbeddedJdbcConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

    @Bean
    @Lazy
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:subject10/demo01/db/h2/schema.sql",
                        "classpath:subject10/demo01/db/h2/test-data.sql")
                .build();
    }

    @Bean
    @Lazy
    public NamedParameterJdbcTemplate jdbcTemplate() {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao() {
        JdbcSingerDao singerDao = new JdbcSingerDao();
        singerDao.setJdbcTemplate(jdbcTemplate());
        return singerDao;
    }
}
