package com.zgy.study.chapter06.subject07.demo01.dao.impl;

import com.zgy.study.chapter06.subject07.demo01.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZGY <br>
 * @date 2019/11/29 16:57 <br>
 * @description JdbcSingerDao <br>
 */
public class JdbcSingerDao implements SingerDao, InitializingBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String findNameById(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select first_name, last_name from singer where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            String result = "";
            while (resultSet.next()) {
                result += resultSet.getString(1);
                result += resultSet.getString(2);
            }
            statement.close();
            return result;
        } catch (SQLException e) {
            LOGGER.error("查询数据出现错误", e);
            return null;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("关闭连接出现错误", e);
                }
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set datasource on SingerDao");
        }
    }
}
