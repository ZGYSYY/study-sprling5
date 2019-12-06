package com.zgy.study.chapter08.subject10.service.impl;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ZGY <br/>
 * @date 2019/12/6 11:38 <br/>
 * @description AuditorAwareBean <br/>
 */
@Component
public class AuditorAwareBean implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ZGYISNBHH");
    }
}
