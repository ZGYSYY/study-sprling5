package com.zgy.study.spring5.base.dao.service;

import com.zgy.study.spring5.base.dao.entity.Singer;

import java.util.List;

/**
 * @author ZGY <br>
 * @date 2019/11/14 16:55 <br>
 * @description SingerService <br>
 */
public interface SingerService {
    /**
     * 获取全部歌手列表
     * @return
     */
    List<Singer> findAll();

    /**
     * 根据 Id 查询歌手
     * @param id
     * @return
     */
    Singer findById(Long id);

    /**
     * 保存歌手
     * @param singer
     * @return
     */
    Singer save(Singer singer);

    /**
     * 获取歌手总数量
     * @return
     */
    Long countAll();
}
