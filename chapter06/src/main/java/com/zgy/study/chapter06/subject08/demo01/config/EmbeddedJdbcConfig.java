package com.zgy.study.chapter06.subject08.demo01.config;

import com.zgy.study.chapter06.subject08.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject08.demo01.dao.impl.JdbcSingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author ZGY <br>
 * @date 2019/11/29 17:01 <br>
 * @description EmbeddedJdbcConfig <br>
 */
@Configuration
public class EmbeddedJdbcConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

            return builder.setType(EmbeddedDatabaseType.H2).addScripts("classpath:subject07/demo01/db/h2/schema.sql",
                    "classpath:subject07/demo01/db/h2/test-data.sql").build();
        } catch (Exception e) {
            LOGGER.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    @Bean
    public SingerDao singerDao() {
        JdbcSingerDao singerDao = new JdbcSingerDao();
        singerDao.setDataSource(dataSource());

        return singerDao;
    }
}
