package com.zgy.study.chapter08.subject09.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Optional;
import java.util.Properties;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 10:01 <br/>
 * @description DataJpaConfig <br/>
 */
@Configuration
@ComponentScan(basePackages = "com.zgy.study.chapter08.subject09.service.impl")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.zgy.study.chapter08.subject09.dao")
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class DataJpaConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataJpaConfig.class);

    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(EmbeddedDatabaseType.H2);
        builder.addScripts("classpath:subject09/schema.sql", "classpath:subject09/test-data.sql");
        return builder.build();
    }

    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    public Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        return properties;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.zgy.study.chapter08.subject09.entity");
        factoryBean.setJpaProperties(properties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
