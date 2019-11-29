package com.zgy.study.chapter06.subject05.demo01;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZGY <br>
 * @date 2019/11/29 15:21 <br>
 * @description DbConfigTest <br>
 */
public class DbConfigTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(DbConfigTest.class);

    @Test
    public void testOne() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject05/demo01/application-context.xml");
        context.refresh();

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);
        testDataSource(dataSource);

        context.close();
    }

    @Test
    public void test2() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);
        testDataSource(dataSource);

        context.close();
    }

    @Test
    public void test3() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject05/demo01/application-context2.xml");
        context.refresh();

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);
        testDataSource(dataSource);

        context.close();
    }

    private void testDataSource(DataSource dataSource) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int mockValue = resultSet.getInt("1");
                Assert.assertTrue(mockValue == 1);
            }
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("Something unexpected happened.", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("connection failed to close.", e);
                }
            }
        }
    }

}
