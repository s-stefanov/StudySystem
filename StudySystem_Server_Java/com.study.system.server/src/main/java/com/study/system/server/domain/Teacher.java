package com.study.system.server.domain;

/**
 * Created by xtreme on 5/2/15.
 */

import javax.persistence.*;

@Entity
@Table(name = "teachers", schema = "StudySystem@mongodb")
public class Teacher {
    @Id
    @Column(name = "teacherId")
    private String teacherId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name= "userId")
    private User user;

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUserData(){
        return this.user;
    }

    public void setUserData(User user){
        this.user = user;
    }
}
