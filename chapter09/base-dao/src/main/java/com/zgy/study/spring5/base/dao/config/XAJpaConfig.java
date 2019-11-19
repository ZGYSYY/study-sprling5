package com.zgy.study.spring5.base.dao.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author ZGY <br>
 * @date 2019/11/18 10:58 <br>
 * @description XAJpaConfig <br>
 */
@Configuration
@EnableJpaRepositories
public class XAJpaConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(XAJpaConfig.class);

    @Bean
    public EntityManagerFactory emfA() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.zgy.study.spring5.base.dao.entity");
        factoryBean.setDataSource(dataSourceA());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName("emfA");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Bean
    public EntityManagerFactory emfB() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.zgy.study.spring5.base.dao.entity");
        factoryBean.setDataSource(dataSourceB());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName("emfB");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    public DataSource dataSourceA() {
        AtomikosDataSourceBean datasource = new AtomikosDataSourceBean();
        datasource.setUniqueResourceName("XADBMSA");
        datasource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        datasource.setXaProperties(xaAProperties());
        datasource.setPoolSize(1);

        return datasource;
    }

    public DataSource dataSourceB() {
        AtomikosDataSourceBean datasource = new AtomikosDataSourceBean();
        datasource.setUniqueResourceName("XADBMSB");
        datasource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        datasource.setXaProperties(xaBProperties());
        datasource.setPoolSize(1);

        return datasource;
    }

    public Properties xaAProperties() {
        Properties properties = new Properties();
        properties.put("databaseName", "my_test_data_a");
        properties.put("user", "mytest_a");
        properties.put("password", "123456");

        return properties;
    }

    public Properties xaBProperties() {
        Properties properties = new Properties();
        properties.put("databaseName", "my_test_data_b");
        properties.put("user", "mytest_b");
        properties.put("password", "654321");

        return properties;
    }

    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
        properties.put("hibernate.transaction.jta.platform", "com.atomikos.icatch.jta.hibernate4.AtomikosPlatform");
        properties.put("hibernate.transaction.coordinator_class", "jta");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);

        return properties;
    }
}
