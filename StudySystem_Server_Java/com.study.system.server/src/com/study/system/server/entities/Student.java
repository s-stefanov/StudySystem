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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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
