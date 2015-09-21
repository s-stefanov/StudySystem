package com.study.system.server.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xtreme on 5/17/15.
 */
@Entity
@Table(name = "homeworks", schema = "StudySystem@mongodb")
public class Homework {
    @Id
    @Column(name = "homeworkId")
    private String homeworkId;

    @Column(name = "url")
    private String url;

    @Column(name = "uploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "studentId")
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
