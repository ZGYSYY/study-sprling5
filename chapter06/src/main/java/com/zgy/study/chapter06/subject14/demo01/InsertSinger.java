package com.zgy.study.chapter06.subject14.demo01;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author ZGY <br>
 * @date 2019/12/2 14:47 <br>
 * @description InsertSinger <br>
 */
public class InsertSinger extends SqlUpdate {

    private static final String SQL_INSERT_SINGER = "insert into singer(first_name, last_name, birth_date) values (:firstName, :lastName, :birthDate)";

    public InsertSinger(DataSource dataSource) {
        super(dataSource, SQL_INSERT_SINGER);
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("lastName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birthDate", Types.DATE));
        super.setGeneratedKeysColumnNames(new String[]{"id"});
        super.setReturnGeneratedKeys(true);
    }
}
