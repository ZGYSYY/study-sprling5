package com.zgy.study.chapter05.subject02.demo02;

/**
 * @author ZGY <br>
 * @date 2019/11/26 14:33 <br>
 * @description SecurityManager <br>
 */
public class SecurityManager {

    public static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String userName, String password) {
        threadLocal.set(new UserInfo(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }
}
