package com.study.system.server.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xtreme on 5/17/15.
 */
@Entity
@Table(name = "HOMEWORKS", schema = "StudySystem")
public class Homework {
    @Id
    @Column(name = "HOMEWORK_ID")
    private String homeworkId;

    @Column(name = "URL")
    private String url;

    @Column(name = "UPLOADED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public Homework() {
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
