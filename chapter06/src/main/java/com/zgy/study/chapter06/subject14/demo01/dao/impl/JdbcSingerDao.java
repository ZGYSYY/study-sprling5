package com.zgy.study.chapter06.subject14.demo01.dao.impl;

import com.zgy.study.chapter06.subject14.demo01.InsertSinger;
import com.zgy.study.chapter06.subject14.demo01.InsertSingerAlbum;
import com.zgy.study.chapter06.subject14.demo01.entities.Album;
import com.zgy.study.chapter06.subject14.demo01.entities.Singer;
import com.zgy.study.chapter06.subject14.demo01.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:10 <br>
 * @description JdbcSingerDao <br>
 */
@Repository
public class JdbcSingerDao implements SingerDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);

    private DataSource dataSource;

    private InsertSinger insertSinger;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.insertSinger = new InsertSinger(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("firstName", singer.getFirstName());
        paramMap.put("lastName", singer.getLastName());
        paramMap.put("birthDate", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        LOGGER.info("===============> 插入数据成功，数据为：[{}]，返回的 Id 为：[{}]", singer, singer.getId());
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        InsertSingerAlbum insertSingerAlbum = new InsertSingerAlbum(dataSource);
        Map<String, Object> paramMap;
        insert(singer);
        List<Album> albums = singer.getAlbums();
        if (albums != null) {
            for (Album album : albums) {
                paramMap = new HashMap<>(10);
                KeyHolder keyHolder = new GeneratedKeyHolder();
                paramMap.put("singerId", singer.getId());
                paramMap.put("releaseDate", album.getReleaseDate());
                paramMap.put("title", album.getTitle());
                insertSingerAlbum.updateByNamedParam(paramMap, keyHolder);
                album.setId(keyHolder.getKey().longValue());
            }
            insertSingerAlbum.flush();
        }
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        List<Singer> result = jdbcTemplate.query("select s.id, s.first_name, s.last_name, s.birth_date, a.id as album_id, a.singer_id, a.release_date, a.title from singer s left join album a on s.id = a.singer_id", x -> {
            Map<Long, Singer> map = new HashMap<>(10);
            Singer singer;

            while (x.next()) {
                long id = x.getLong("id");
                singer = map.get(id);
                if (singer == null) {
                    singer = new Singer();
                    singer.setId(id);
                    singer.setFirstName(x.getString("first_name"));
                    singer.setLastName(x.getString("last_name"));
                    singer.setBirthDate(x.getDate("birth_date"));
                    singer.setAlbums(new ArrayList<>());
                    map.put(id, singer);
                }
                long albumId = x.getLong("album_id");
                if (albumId > 0) {
                    Album album = new Album();
                    album.setId(albumId);
                    album.setSingerId(id);
                    album.setTitle(x.getString("title"));
                    album.setReleaseDate(x.getDate("release_date"));
                    singer.getAlbums().add(album);
                }
            }

            return new ArrayList(map.values());
        });
        return result;
    }
}
