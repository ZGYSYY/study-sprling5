package com.zgy.study.setter4injection.demo14;

/**
 * @author ZGY <br>
 * @date 2019/11/20 10:12 <br>
 * @description Inspiration <br>
 */
public class Inspiration {

    private String lyric = "好好学习，天天向上！";

    public Inspiration(String lyric) {
        this.lyric = lyric;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}
