package com.zgy.study.chapter06.subject10.demo01.dao.impl;

import com.zgy.study.chapter06.subject10.demo01.dao.SingerDao;
import com.zgy.study.chapter06.subject10.demo01.entities.Album;
import com.zgy.study.chapter06.subject10.demo01.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZGY <br>
 * @date 2019/12/2 10:10 <br>
 * @description JdbcSingerDao <br>
 */
public class JdbcSingerDao implements SingerDao, InitializingBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);

    public NamedParameterJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = jdbcTemplate.query("select s.id, s.first_name, s.last_name, s.birth_date, a.id as album_id, a.singer_id, a.title, a.release_date from singer s left join album a on s.id = a.singer_id",
                (resultSet) -> {
                    Map<Long, Singer> map = new HashMap<>(10);
                    Singer singer = null;
                    while (resultSet.next()) {
                        long id = resultSet.getLong("id");
                        singer = map.get(id);
                        if (singer == null) {
                            singer = new Singer();
                            singer.setId(id);
                            singer.setFirstName(resultSet.getString("first_name"));
                            singer.setLastName(resultSet.getString("last_name"));
                            singer.setBirthDate(resultSet.getDate("birth_date"));
                            singer.setAlbums(new ArrayList<>(16));
                            map.put(id, singer);
                        }
                        long albumId = resultSet.getLong("album_id");
                        if (albumId > 0) {
                            Album album = new Album();
                            album.setId(albumId);
                            album.setSingerId(id);
                            album.setTitle(resultSet.getString("title"));
                            album.setReleaseDate(resultSet.getDate("release_date"));
                            singer.getAlbums().add(album);
                        }
                    }
                    return new ArrayList<>(map.values());
                });
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("======================> 执行了 public void afterPropertiesSet() throws Exception 方法");
        if (jdbcTemplate == null) {
            throw new BeanCreationException("jdbcTemplate 为空");
        }
    }
}
