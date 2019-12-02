package com.zgy.study.chapter06.subject14.demo01;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author ZGY <br>
 * @date 2019/12/2 15:19 <br>
 * @description InsertSingerAlbum <br>
 */
public class InsertSingerAlbum extends BatchSqlUpdate {

    private static final String SQL_INSERT_SINGER_ALBUM = "insert into album (singer_id, title, release_date) values (:singerId, :title, :releaseDate)";

    private static final int BATCH_SIZE = 2;

    public InsertSingerAlbum(DataSource dataSource) {
        super(dataSource, SQL_INSERT_SINGER_ALBUM);
        super.setBatchSize(BATCH_SIZE);
        super.setGeneratedKeysColumnNames(new String[]{"id"});
        super.setReturnGeneratedKeys(true);
        super.declareParameter(new SqlParameter("singerId", Types.INTEGER));
        super.declareParameter(new SqlParameter("title", Types.VARCHAR));
        super.declareParameter(new SqlParameter("releaseDate", Types.DATE));
    }
}
