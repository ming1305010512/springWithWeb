package com.alsa.mvc.handlerMethods.jaksonJson;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/6
 * @Time: 15:39
 * @Description:
 */
public class User {
    public interface WithoutPasswordView {};
    public interface WithPasswordView extends WithoutPasswordView {};

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return this.username;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
