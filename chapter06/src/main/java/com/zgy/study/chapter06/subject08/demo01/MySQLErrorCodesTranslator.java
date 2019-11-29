package com.zgy.study.chapter06.subject08.demo01;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

/**
 * @author ZGY <br>
 * @date 2019/11/29 17:46 <br>
 * @description MySQLErrorCodesTranslator <br>
 */
public class MySQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {

    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
        if (sqlEx.getErrorCode() == -12345) {
            return new DeadlockLoserDataAccessException(task, sqlEx);
        }
        return null;
    }
}
