package com.zgy.study.spring5.transactions.jta.config;

import com.atomikos.icatch.config.UserTransactionService;
import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Properties;

/**
 * @author ZGY <br>
 * @date 2019/11/18 12:15 <br>
 * @description ServicesConfig <br>
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.zgy.study.spring5.transactions.jta.services")
public class ServicesConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServicesConfig.class);

    @Bean
    public UserTransactionService userTransactionService() {
        Properties properties = new Properties();
        properties.put("com.atomikos.icatch.service", "com.atomikos.icatch.standalone.UserTransactionServiceFactory");

        return new UserTransactionServiceImp(properties);
    }

    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setStartupTransactionService(false);
        userTransactionManager.setForceShutdown(true);

        return userTransactionManager;
    }

    public UserTransaction userTransaction() {
        UserTransactionImp userTransaction = new UserTransactionImp();
        try {
            userTransaction.setTransactionTimeout(300);
        } catch (SystemException e) {
            LOGGER.error("Configuration exception.", e);
            return null;
        }

        return userTransaction;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
        jtaTransactionManager.setUserTransaction(userTransaction());

        return jtaTransactionManager;
    }
}
