package com.zgy.study.spring5.base.dao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;

/**
 * @author ZGY <br>
 * @date 2019/11/14 16:49 <br>
 * @description 事务管理配置 <br>
 */
@Configuration
//@EnableTransactionManagement
@ComponentScan(basePackages = "com.zgy.study.spring5.base.dao")
public class ServicesConfig {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * 配置事务管理器
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory);
    }

    /**
     * 使用 TransactionTemplate 实现编程式事务
     * @return
     */
    @Bean
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager());
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_NEVER);
        transactionTemplate.setTimeout(30);

        return transactionTemplate;
    }
}
