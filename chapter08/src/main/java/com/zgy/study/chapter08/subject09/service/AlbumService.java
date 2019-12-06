package com.zgy.study.chapter08.subject09.service;

import com.zgy.study.chapter08.subject09.entity.Album;
import com.zgy.study.chapter08.subject09.entity.Singer;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 10:48 <br/>
 * @description AlbumService <br/>
 */
public interface AlbumService {

    List<Album> findBySinger(Singer singer);

    List<Album> findByTitle(String title);
}
