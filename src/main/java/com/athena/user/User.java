package com.athena.user;

public class User {
    private final Integer userId;
    private final String userName;

    //username
    //password
    //roles?
    //authority?



    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
