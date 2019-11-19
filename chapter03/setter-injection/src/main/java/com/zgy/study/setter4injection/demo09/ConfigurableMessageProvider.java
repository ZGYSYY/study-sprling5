package com.zgy.study.setter4injection.demo09;

import com.zgy.study.chapter02.helloworld.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: ZGY <br>
 * @date: 2019-11-19 21:11 <br>
 * @description: ConfigurableMessageProvider <br>
 * @version: 1.0 <br>
 */
@Component
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(@Value("好好学习，天天向上！") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
