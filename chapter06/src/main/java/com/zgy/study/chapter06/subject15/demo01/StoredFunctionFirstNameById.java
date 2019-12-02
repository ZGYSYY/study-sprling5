package com.zgy.study.chapter06.subject15.demo01;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author ZGY <br>
 * @date 2019/12/2 16:16 <br>
 * @description StoredFunctionFirstNameById <br>
 */
public class StoredFunctionFirstNameById extends SqlFunction<String> {

    private static final String SQL = "select get_first_name_by_id(?)";

    public StoredFunctionFirstNameById(DataSource dataSource) {
        super(dataSource, SQL);
        super.declareParameter(new SqlParameter(Types.INTEGER));
        super.compile();
    }
}
