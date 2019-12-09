package com.zgy.study.chapter09to2.subject06.config;

import com.atomikos.icatch.config.UserTransactionService;
import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Properties;

/**
 * @author ZGY <br/>
 * @date 2019/12/9 10:19 <br/>
 * @description AppConfig <br/>
 */
@Configuration
@ComponentScan(basePackages = "com.zgy.study.chapter09to2.subject06.service.impl")
@EnableJpaRepositories(basePackages = "com.zgy.study.chapter09to2.subject06.dao")
@EnableTransactionManagement
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    private Properties properties(String user, String password, String database) {
        Properties properties = new Properties();
        properties.put("url", "jdbc:mysql://localhost:3306/"+ database +"?serverTimezone=GMT%2B8");
        properties.put("user", user);
        properties.put("password", password);
        return properties;
    }

    private DataSource dataSource(Properties properties, String uniqueResourceName) {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName(uniqueResourceName);
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        dataSource.setXaProperties(properties);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(10);
        dataSource.setBorrowConnectionTimeout(60);
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource(properties("prospring5_a", "prospring5_a", "musicdb_a"), "dataSource"));
        factoryBean.setPackagesToScan("com.zgy.study.chapter09to2.subject06.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPersistenceUnitName("entityManagerFactory");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.transaction.coordinator_class", "jta");
        factoryBean.setJpaProperties(properties);
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory2() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource(properties("prospring5_b", "prospring5_b", "musicdb_b"), "dataSource2"));
        factoryBean.setPackagesToScan("com.zgy.study.chapter09to2.subject06.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPersistenceUnitName("entityManagerFactory2");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.transaction.coordinator_class", "jta");
        properties.put("hibernate.show_sql", true);
        factoryBean.setJpaProperties(properties);
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public UserTransactionService userTransactionService() {
        return new UserTransactionServiceImp();
    }

    @Bean
    @DependsOn("userTransactionService")
    public UserTransactionManager userTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setStartupTransactionService(false);
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    @Bean
    @DependsOn("userTransactionService")
    public UserTransaction userTransaction() {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        try {
            userTransactionImp.setTransactionTimeout(300);
        } catch (SystemException e) {
            LOGGER.error("Configuration exception.", e);
            return null;
        }
        return userTransactionImp;
    }

    @Bean
    public JtaTransactionManager transactionManager() {
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        transactionManager.setTransactionManager(userTransactionManager());
        transactionManager.setUserTransaction(userTransaction());
        return transactionManager;
    }
}
