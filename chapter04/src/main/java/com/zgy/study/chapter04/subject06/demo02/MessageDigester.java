package com.zgy.study.chapter04.subject06.demo02;

import java.security.MessageDigest;

/**
 * @author ZGY <br>
 * @date 2019/11/22 11:18 <br>
 * @description MessageDigester <br>
 */
public class MessageDigester {

    private MessageDigest messageDigest;
    private MessageDigest messageDigest2;

    public void setMessageDigest(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    public void setMessageDigest2(MessageDigest messageDigest2) {
        this.messageDigest2 = messageDigest2;
    }

    public void digest(String msg) {
        System.out.println("使用 messageDigest 计算摘要");
        digest(msg, messageDigest);

        System.out.println("使用 messageDigest2 计算摘要");
        digest(msg, messageDigest2);
    }

    public void digest(String msg, MessageDigest messageDigest) {
        System.out.println("使用的是：" + messageDigest.getAlgorithm() + "算法");
        messageDigest.reset();
        byte[] bytes = msg.getBytes();
        byte[] digest = messageDigest.digest(bytes);
        System.out.println(digest);
    }
}
