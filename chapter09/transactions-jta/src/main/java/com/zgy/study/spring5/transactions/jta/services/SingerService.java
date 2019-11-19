package com.zgy.study.spring5.transactions.jta.services;

import com.zgy.study.spring5.transactions.jta.entity.Singer;

/**
 * @author ZGY <br>
 * @date 2019/11/14 16:55 <br>
 * @description SingerService <br>
 */
public interface SingerService {

    /**
     * 保存歌手
     * @param singer
     * @return
     */
    Singer save(Singer singer);
}
