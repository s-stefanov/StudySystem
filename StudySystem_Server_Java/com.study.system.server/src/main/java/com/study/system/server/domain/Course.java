package com.study.system.server.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xtreme on 5/2/15.
 */
@Entity
@Table(name = "courses", schema = "StudySystem@mongodb")
public class Course {
    @Id
    @Column(name = "courseId")
    private String courseId;

    @Column(name = "name")
    private String name;

    @OneToOne(optional = false, cascade = CascadeType.ALL, targetEntity = Teacher.class)
    @JoinColumn(name= "teacherId")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = {
                    @JoinColumn(name = "courseId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "studentId")
            })
    private Set<Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="courses")
    private Set<Module> modules;
    //Constructors, Getters, setters here

    public Course(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
