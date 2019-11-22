package com.zgy.study.chapter04.subject08.demo01;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ZGY <br>
 * @date 2019/11/22 13:39 <br>
 * @description MessageDigestFactory <br>
 */
public class MessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
