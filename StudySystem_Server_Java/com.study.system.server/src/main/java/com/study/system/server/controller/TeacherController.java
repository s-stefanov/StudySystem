package com.study.system.server.controller;

import com.google.gson.GsonBuilder;
import com.study.system.server.Configuration;
import com.study.system.server.Constants;
import com.study.system.server.domain.Teacher;
import com.study.system.server.domain.User;
import com.study.system.server.validation.Validator;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.exception.NotFoundException;
import org.restexpress.exception.ServiceException;

import javax.persistence.EntityManager;

/**
 * Created by xtreme on 4/26/15.
 */
public class TeacherController extends AbstractController {

    public TeacherController(Configuration config){
        super(new GsonBuilder().create(), new Validator(), config);
    }

    public Object[] readAll(Request request, Response response) {
        return getTeacherService().getAllTeachers();
    }

    public Teacher getTeacherById(Request request, Response response) {
        String id = request.getHeader(Constants.Teacher.ID_PARAM);
        Teacher teacher = getTeacherById(id);
        if(teacher == null) {
            throw new NotFoundException("Teacher with ID: " + id + " not found.");
        }
        return teacher;
    }

    private Teacher getTeacherById(String id) {
        return getTeacherService().getTeacherById(id);
    }

    public Teacher createTeacher(Request request, Response response){
        getValidator().validate(request);
        String requestBody = convertStreamToString(request.getBodyAsStream());
        Teacher teacher = convertJson(requestBody, Teacher.class);
        getValidator().validateTeacher(teacher);

        User user = teacher.getUserData();
        if(user.getUserId() != null){
            User result = getUserService().getUserById(user.getUserId());
            if(result != null) {
                teacher.setUserData(result);
            }
        } else {
            getValidator().validateUser(user);
            getUserService().createUser(user);
        }

        if(!getTeacherService().createTeacher(teacher)){
            throw new ServiceException("Error persisiting Teacher. We are working on the problem.");
        }
        return teacher;
    }

    public User getUserByTeacherId(Request request, Response response) {
        String id = request.getHeader(Constants.Teacher.ID_PARAM);
        Teacher teacher = getTeacherById(id);
        if(teacher == null) {
            throw new NotFoundException("Teacher with ID: " + id + " not found.");
        }
        return teacher.getUserData();
    }
}
