package com.study.system.server.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by xtreme on 5/2/15.
 */
@Entity
@Table(name = "COURSES", schema = "StudySystem")
public class Course {
    @Id
    @Column(name = "COURSE_ID")
    private String courseId;

    @Column(name = "NAME")
    private String name;

    @OneToOne(optional = false, cascade = CascadeType.ALL, targetEntity = Teacher.class)
    @JoinColumn(name= "TEACHER_ID")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = {
                    @JoinColumn(name = "COURSE_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "STUDENT_ID")
            })
    private Set<Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="course")
    private Set<Module> modules;
    //Constructors, Getters, setters here
    
    public Course() {
    	
    }
    
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
