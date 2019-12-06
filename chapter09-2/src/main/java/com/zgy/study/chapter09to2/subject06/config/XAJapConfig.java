package com.zgy.study.chapter09to2.subject06.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 15:14 <br/>
 * @description XAJapConfig <br/>
 */
@Configuration
@EnableJpaRepositories
public class XAJapConfig {

    @Bean
    public EntityManagerFactory emfA() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com.zgy.study.chapter09to2.subject06.entity");
        factoryBean.setPersistenceUnitName("emfA");

        Properties properties = new Properties();
        properties.put("hibernate.transaction.coordinator_class", "jta");
        properties.put("hibernate.transaction.jta.platform", "com.atomikos.icatch.jta.hibernate4.AtomikosPlatform");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "created-drop");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        factoryBean.setJpaProperties(properties);


        properties.clear();
        properties.put("databaseName", "musicdb_a");
        properties.put("user", "prospring5_a");
        properties.put("password", "prospring5_a");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaProperties(properties);
        dataSource.setPoolSize(1);
        dataSource.setUniqueResourceName("XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");

        factoryBean.setDataSource(dataSource);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public EntityManagerFactory emfB() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com.zgy.study.chapter09to2.subject06.entity");
        factoryBean.setPersistenceUnitName("emfB");

        Properties properties = new Properties();
        properties.put("hibernate.transaction.coordinator_class", "jta");
        properties.put("hibernate.transaction.jta.platform", "com.atomikos.icatch.jta.hibernate4.AtomikosPlatform");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "created-drop");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        factoryBean.setJpaProperties(properties);


        properties.clear();
        properties.put("databaseName", "musicdb_b");
        properties.put("user", "prospring5_b");
        properties.put("password", "prospring5_b");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaProperties(properties);
        dataSource.setPoolSize(1);
        dataSource.setUniqueResourceName("XADBMSB");
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");

        factoryBean.setDataSource(dataSource);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
