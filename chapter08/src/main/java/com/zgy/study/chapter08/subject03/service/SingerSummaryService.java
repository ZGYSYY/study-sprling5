package com.zgy.study.chapter08.subject03.service;

import com.zgy.study.chapter08.subject03.view.SingerSummary;

import java.util.List;

/**
 * @author ZGY <br/>
 * @date 2019/12/5 15:25 <br/>
 * @description SingerSummaryService <br/>
 */
public interface SingerSummaryService {

    List<SingerSummary> findAll();
}
