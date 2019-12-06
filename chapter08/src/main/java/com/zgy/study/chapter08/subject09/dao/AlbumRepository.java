package com.zgy.study.chapter08.subject09.dao;

import com.zgy.study.chapter08.subject09.entity.Album;
import com.zgy.study.chapter08.subject09.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 10:45 <br/>
 * @description AlbumRepository <br/>
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findBySinger(Singer singer);

    @Query("select a from Album a where a.title like %:title%")
    List<Album> findByTitle(@Param("title") String title);
}
