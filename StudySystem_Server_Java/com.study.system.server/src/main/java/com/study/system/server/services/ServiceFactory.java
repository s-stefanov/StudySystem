package com.study.system.server.services;

import com.study.system.server.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by xtreme on 5/16/15.
 */
public class ServiceFactory {
    private EntityManagerFactory emf;

    public ServiceFactory(String persistenceUnit){
        emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    public UserService createUserService(){
        return new UserService(emf);
    }

    public TeacherService createTeacherService() {
        return new TeacherService(emf);
    }

    public StudentService createStudentService(){
        return new StudentService(emf);
    }
}
