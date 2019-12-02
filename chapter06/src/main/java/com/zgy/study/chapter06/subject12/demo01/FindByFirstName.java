package com.zgy.study.chapter06.subject12.demo01;

import com.zgy.study.chapter06.subject12.demo01.entities.Singer;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author ZGY <br>
 * @date 2019/12/2 14:07 <br>
 * @description FindByFirstName <br>
 */
public class FindByFirstName extends MappingSqlQuery<Singer> {

    private final static String FIND_BY_FIRST_NAME = "select id, first_name, last_name, birth_date from singer where first_name = :firstName";

    public FindByFirstName(DataSource dataSource) {
        super(dataSource, FIND_BY_FIRST_NAME);
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
    }

    @Override
    protected Singer mapRow(ResultSet resultSet, int i) throws SQLException {
        Singer singer = new Singer();
        singer.setId(resultSet.getLong("id"));
        singer.setFirstName(resultSet.getString("first_name"));
        singer.setLastName(resultSet.getString("last_name"));
        singer.setBirthDate(resultSet.getDate("birth_date"));
        return singer;
    }
}
