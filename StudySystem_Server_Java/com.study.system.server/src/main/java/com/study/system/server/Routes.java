package com.study.system.server;

import io.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

/**
 * Created by xtreme on 4/19/15.
 */
public class Routes {
    public Routes() {
    }

    public void define(RestExpress server, Configuration config) {

        server.uri("/users", config.getUserController())
                .action("readAll", HttpMethod.GET)
                .name("Read all users").performSerialization();
        server.uri("/users", config.getUserController())
                .action("createUser", HttpMethod.POST)
                .name("Create user").performSerialization();
        server.uri("/users/{" + Constants.User.ID_PARAM + "}", config.getUserController())
                .action("getUserById", HttpMethod.GET)
                .name("User by id").performSerialization();

        server.uri("/teachers", config.getTeacherController())
                .action("readAll", HttpMethod.GET)
                .name("Read all teachers").performSerialization();
        server.uri("/teachers/{" + Constants.Teacher.ID_PARAM + "}", config.getTeacherController())
                .action("getTeacherById", HttpMethod.GET)
                .name("Teacher by id").performSerialization();
        server.uri("/teachers", config.getTeacherController())
                .action("createTeacher", HttpMethod.POST)
                .name("Create teacher").performSerialization();
        server.uri("/teachers/{" + Constants.Teacher.ID_PARAM + "}/user", config.getTeacherController())
                .action("getUserByTeacherId", HttpMethod.GET)
                .name("User by teacher id").performSerialization();

        server.uri("/students", config.getStudentController())
                .action("readAll", HttpMethod.GET)
                .name("Read all students").performSerialization();
        server.uri("/students/{" + Constants.Student.ID_PARAM + "}", config.getStudentController())
                .action("getStudentById", HttpMethod.GET)
                .name("Student by id").performSerialization();
        server.uri("/students", config.getStudentController())
                .action("createStudent", HttpMethod.POST)
                .name("Create student").performSerialization();
        server.uri("/students/{" + Constants.Student.ID_PARAM + "}/user", config.getStudentController())
                .action("getUserByStudentId", HttpMethod.GET)
                .name("User by student id").performSerialization();
    }
}
