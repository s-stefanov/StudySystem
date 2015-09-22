package com.study.system.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "StudySystem")
public class User {
    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name="USERNAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="STATUS")
    private UserStatus status;

    public User()
    {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
