package com.study.system.server;

import com.study.system.server.controller.*;
import com.study.system.server.services.ServiceFactory;
import com.study.system.server.validation.Validator;
import org.restexpress.RestExpress;
import org.restexpress.common.exception.ConfigurationException;
import org.restexpress.util.Environment;

import java.util.Properties;

/**
 * Created by xtreme on 4/18/15.
 */
public class Configuration extends Environment {
    private static final String PORT_PROPERTY = "port";
    private static final String BASE_URL_PROPERTY = "base.url";
    private static final String SERVER_NAME_PROPERTY = "name";
    private static final String PERSISITENCE_UNIT_PROPERTY = "persistence-unit";

    private static final String REST_SERVER_DEFAULT_NAME = "REST Server";
    private static final String DEFAULT_HOST_URL = "http://localhost";
    private static final String DEFAULT_PERSISITENCE_UNIT = "mongodb";

    private int port;
    private String baseUrl;
    private String name;
    private String persistenceUnit;
    private Properties loadedProperties;

    private UserContoller userController;
    private TeacherController teacherController;
    private StudentController studentController;
    private CourseController courseController;
    private ModuleController moduleController;
    private Validator validator = new Validator();
    private ServiceFactory serviceFactory;

    @Override
    protected void fillValues(Properties p) throws ConfigurationException {
        loadedProperties = p;
        this.port = Integer.parseInt(p.getProperty(PORT_PROPERTY, String.valueOf(RestExpress.DEFAULT_PORT)));
        this.baseUrl = p.getProperty(BASE_URL_PROPERTY, DEFAULT_HOST_URL + ":" + String.valueOf(this.port));
        this.name = p.getProperty(SERVER_NAME_PROPERTY, REST_SERVER_DEFAULT_NAME);
        this.persistenceUnit = p.getProperty(PERSISITENCE_UNIT_PROPERTY, DEFAULT_PERSISITENCE_UNIT);
        this.serviceFactory = new ServiceFactory(this.persistenceUnit);
        this.userController = new UserContoller(this);
        this.teacherController = new TeacherController(this);
        this.studentController = new StudentController(this);
        this.moduleController = new ModuleController(this);
        this.courseController = new CourseController(this);
    }

    public int getPort() {
        return this.port;
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public String getName(){
        return this.name;
    }

    public String getPersistenceUnit() {
        return persistenceUnit;
    }

    public StudentController getStudentController() {
        return this.studentController;
    }

    public CourseController getCourseController() {
        return this.courseController;
    }

    public ModuleController getModuleController() {
        return this.moduleController;
    }

    public UserContoller getUserController() {
        return this.userController;
    }

    public TeacherController getTeacherController(){
        return this.teacherController;
    }

    public Validator getValidator() {
        return this.validator;
    }

    public Properties getPropertiesMap(){
        return this.loadedProperties;
    }

    public ServiceFactory getServiceFactory(){
        return this.serviceFactory;
    }
}
