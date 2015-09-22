package com.study.system.server.entities;

import javax.persistence.*;

/**
 * Created by xtreme on 5/2/15.
 */
@Entity
@Table(name = "STUDENTS", schema = "StudySystem")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name= "USER_ID")
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
