package com.zgy.study.chapter06.subject12.demo01;

import com.zgy.study.chapter06.subject12.demo01.entities.Singer;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZGY <br>
 * @date 2019/12/2 13:49 <br>
 * @description SelectAllSingers <br>
 */
public class SelectAllSingers extends MappingSqlQuery<Singer> {

    private final static String SQL_SELECT_ALL_SINGERS = "select id, first_name, last_name, birth_date from singer";

    public SelectAllSingers(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_SINGERS);
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
