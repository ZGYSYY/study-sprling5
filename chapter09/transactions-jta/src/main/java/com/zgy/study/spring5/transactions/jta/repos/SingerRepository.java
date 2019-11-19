package com.zgy.study.spring5.transactions.jta.repos;


import com.zgy.study.spring5.transactions.jta.entity.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ZGY <br>
 * @date 2019/11/14 16:59 <br>
 * @description SingerRepository <br>
 */
public interface SingerRepository extends CrudRepository<Singer, Long> {
    /**
     * 获取歌手总数
     * @return
     */
    @Query("select count(s) from Singer s")
    Long countAllSingers();
}
