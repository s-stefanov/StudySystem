package com.study.system.server.controller;

import com.google.gson.Gson;
import com.study.system.server.Configuration;
import com.study.system.server.services.ServiceFactory;
import com.study.system.server.services.StudentService;
import com.study.system.server.services.TeacherService;
import com.study.system.server.services.UserService;
import com.study.system.server.validation.Validator;

import javax.persistence.*;
import java.lang.reflect.Type;

/**
 * Created by xtreme on 5/3/15.
 */
public abstract class AbstractController {
    private Validator validator;
    private Gson gson;
    private Configuration config;
    private UserService userService;
    private TeacherService teacherService;
    private StudentService studentService;

    public AbstractController(Gson gson, Validator validator, Configuration config) {
        this.validator = validator;
        this.gson = gson;
        this.config = config;
        this.userService = config.getServiceFactory().createUserService();
        this.teacherService = config.getServiceFactory().createTeacherService();
        this.studentService = config.getServiceFactory().createStudentService();
    }

    public Validator getValidator() {
        return this.validator;
    }

    public Configuration getConfig(){
        return this.config;
    }

    public Gson getGson() {
        return gson;
    }

    protected static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    protected <T> T convertJson(String json, Type objectType) {
        return gson.fromJson(json, objectType);
    }

    protected UserService getUserService(){
        return this.userService;
    }

    protected TeacherService getTeacherService(){
        return this.teacherService;
    }

    protected StudentService getStudentService() {
        return studentService;
    }
}
