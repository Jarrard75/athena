package com.athena.user;

import com.athena.calendar.Event;
import com.athena.goals.Goal;

import java.util.List;

public class User {

    private final int userId;
    private final String userName;
    private String password="";
    private List<Event> userEvents;
    private List<Goal> userGoals;

    //username
    //password
    //roles?
    //authority?



    public User(Integer userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public User(String username) {
        this.userId = (int)Math.floor(Math.random()*100);
        this.userName = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
