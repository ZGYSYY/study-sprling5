package com.zgy.study.chapter08.subject09.service.impl;

import com.zgy.study.chapter08.subject09.dao.AlbumRepository;
import com.zgy.study.chapter08.subject09.entity.Album;
import com.zgy.study.chapter08.subject09.entity.Singer;
import com.zgy.study.chapter08.subject09.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 10:49 <br/>
 * @description AlbumServiceImple <br/>
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> findBySinger(Singer singer) {
        return albumRepository.findBySinger(singer);
    }

    @Override
    public List<Album> findByTitle(String title) {
        return albumRepository.findByTitle(title);
    }
}
