package com.example.recyclerviewdemo;

public class User {
    private String userName;
    private String lastActive;

    public User(String userName, String lastActive) {
        this.userName = userName;
        this.lastActive = lastActive;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastActive() {
        return lastActive;
    }

    public void setLastActive(String lastActive) {
        this.lastActive = lastActive;
    }
}
