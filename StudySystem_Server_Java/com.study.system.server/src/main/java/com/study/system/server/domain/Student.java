package com.study.system.server.domain;

import javax.persistence.*;

/**
 * Created by xtreme on 5/2/15.
 */
@Entity
@Table(name = "students", schema = "StudySystem@mongodb")
public class Student {
    @Id
    @Column(name = "studentId")
    private String studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name= "userId")
    private User user;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
