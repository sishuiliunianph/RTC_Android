package com.ibm.rtc.rtc.account;

/**
 * Created by v-wajie on 2015/12/11.
 */
public class Account {
    private final String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
