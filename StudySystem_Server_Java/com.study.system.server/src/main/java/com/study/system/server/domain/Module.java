package com.study.system.server.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by xtreme on 5/2/15.
 */
@Entity
@Table(name = "modules", schema = "StudySystem@mongodb")
public class Module {
    @Id
    @Column(name = "moduleId")
    private String moduleId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "content")
    private String content;

    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @ManyToOne(optional = false, targetEntity = Course.class)
    @JoinColumn(name="courseId")
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Homework.class)
    @JoinColumn(name = "homeworkdId")
    private Set<Homework> homeworks;

    public Module() {
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks) {
        this.homeworks = homeworks;
    }
}
