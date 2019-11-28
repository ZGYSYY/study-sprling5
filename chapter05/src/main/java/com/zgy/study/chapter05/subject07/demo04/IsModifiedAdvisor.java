package com.zgy.study.chapter05.subject07.demo04;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @author ZGY <br>
 * @date 2019/11/27 15:55 <br>
 * @description IsModifiedAdvisor <br>
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {

    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
