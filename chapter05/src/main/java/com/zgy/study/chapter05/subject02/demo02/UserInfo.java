package com.zgy.study.chapter05.subject02.demo02;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:32 <br>
 * @description UserInfo <br>
 */
public class UserInfo {

    private String userName;
    private String password;

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
