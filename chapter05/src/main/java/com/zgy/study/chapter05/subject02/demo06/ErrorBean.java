package com.zgy.study.chapter05.subject02.demo06;

/**
 * @author ZGY <br>
 * @date 2019/11/26 16:09 <br>
 * @description ErrorBean <br>
 */
public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Generic Exception");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException{
        throw new IllegalArgumentException("IllegalArgument Exception");
    }
}
