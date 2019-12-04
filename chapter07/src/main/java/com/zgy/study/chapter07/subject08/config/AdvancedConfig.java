package com.zgy.study.chapter07.subject08.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author ZGY <br/>
 * @date 2019/12/4 13:36 <br/>
 * @description AdvancedConfig <br/>
 */
@Configuration
@PropertySource("classpath:subject08/h2-jdbc.properties")
@ComponentScan(basePackages = {"com.zgy.study.chapter07.subject08.dao.impl", "com.zgy.study.chapter07.subject08.config"})
@EnableTransactionManagement
public class AdvancedConfig {

    @Value("${h2.jdbc.username}")
    private String username;

    @Value("${h2.jdbc.password}")
    private String password;

    @Value("${h2.jdbc.driverClassName}")
    private String driverClassName;

    @Value("${h2.jdbc.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.format_sql", false);
        properties.put("hibernate.use_sql_comments", false);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.dbc.fetch_size", 50);
        properties.put("hibernate.hbm2ddl.auto", "create-drop");

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.zgy.study.chapter07.subject08.entities");
        builder.addProperties(properties);
        return builder.buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
