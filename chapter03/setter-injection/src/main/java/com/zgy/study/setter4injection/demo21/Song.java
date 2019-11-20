package com.zgy.study.setter4injection.demo21;

/**
 * @author ZGY <br>
 * @date 2019/11/20 11:50 <br>
 * @description Song <br>
 */
public class Song {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                '}';
    }
}
