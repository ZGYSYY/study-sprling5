package com.zgy.study.setter4injection.demo22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ZGY <br>
 * @date 2019/11/20 11:50 <br>
 * @description Song <br>
 */
@Component
public class Song {

    private String title;

    public String getTitle() {
        return title;
    }

    @Autowired
    public void setTitle(@Value("OJBK") String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                '}';
    }
}
