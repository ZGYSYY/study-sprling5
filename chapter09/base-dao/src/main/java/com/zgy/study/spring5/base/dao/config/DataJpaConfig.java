package com.zgy.study.spring5.base.dao.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Properties;

/**
 * @author ZGY <br>
 * @date 2019/11/14 16:19 <br>
 * @description 数据源配置 <br>
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.zgy.study.spring5.base.dao.repos")
public class DataJpaConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataJpaConfig.class);

    /**
     * 配置数据源
     * @return
     */
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource driverDataSource = new SimpleDriverDataSource();
        try {
            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName("org.h2.Driver");
            driverDataSource.setDriverClass(driver);
            driverDataSource.setUrl("jdbc:h2:tcp://localhost/~/h2/spring-study");
            driverDataSource.setUsername("root");
            driverDataSource.setPassword("root");

            return driverDataSource;
        } catch (ClassNotFoundException e) {
            LOGGER.error("数据源对象创建失败", e);

            return null;
        }
    }

    /**
     * 配置 hibernate 属性
     * @return
     */
    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        // 配置 hibernate 方言
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        // 自动创建表和删除表
        hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        // 格式化 SQL
        hibernateProperties.put("hibernate.format_sql", true);
        // 显示 SQL
        hibernateProperties.put("hibernate.show_sql", true);
        // TODO
        hibernateProperties.put("hibernate.max_fetch_depth", 3);
        // TODO
        hibernateProperties.put("hibernate.jdbc.batch_size", 10);
        // TODO
        hibernateProperties.put("hibernate.jdbc.fetch_size", 50);

        return hibernateProperties;
    }

    /**
     * 配置 JPA 适配器
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        return new HibernateJpaVendorAdapter();
    }

    /**
     * 配置实体管理工厂
     * @return
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.zgy.study.spring5.base.dao.entity");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();

        return factoryBean.getNativeEntityManagerFactory();
    }
}
