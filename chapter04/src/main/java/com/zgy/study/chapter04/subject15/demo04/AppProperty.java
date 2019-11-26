package com.zgy.study.chapter04.subject15.demo04;

/**
 * @author ZGY <br>
 * @date 2019/11/26 10:25 <br>
 * @description AppProperty <br>
 */
public class AppProperty {

    private String applicationHome;
    private String userHome;

    public String getApplicationHome() {
        return applicationHome;
    }

    public void setApplicationHome(String applicationHome) {
        this.applicationHome = applicationHome;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    @Override
    public String toString() {
        return "AppProperty{" +
                "applicationHome='" + applicationHome + '\'' +
                ", userHome='" + userHome + '\'' +
                '}';
    }
}
