package com.zgy.study.chapter08.subject07.dao;

import com.zgy.study.chapter08.subject07.entity.Singer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 9:58 <br/>
 * @description SingerRepository <br/>
 */
public interface SingerRepository extends CrudRepository<Singer, Long> {

    List<Singer> findByFirstName(String firstName);

    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
