package com.zgy.study.setter4injection;

/**
 * @author ZGY <br>
 * @date 2019/11/19 16:39 <br>
 * @description BookwormOracle <br>
 */
public class BookwormOracle implements Oracle{
    @Override
    public String defineMeaningOfLife() {
        return "好好学习，天天向上！";
    }
}
