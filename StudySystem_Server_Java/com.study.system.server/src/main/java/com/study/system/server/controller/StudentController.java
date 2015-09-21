package com.study.system.server.controller;

import com.google.gson.GsonBuilder;
import com.study.system.server.Configuration;
import com.study.system.server.Constants;
import com.study.system.server.domain.Student;
import com.study.system.server.domain.Teacher;
import com.study.system.server.domain.User;
import com.study.system.server.validation.Validator;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.exception.NotFoundException;
import org.restexpress.exception.ServiceException;

/**
 * Created by xtreme on 4/26/15.
 */
public class StudentController extends AbstractController{
    public StudentController(Configuration config) {
        super(new GsonBuilder().create(), new Validator(), config);
    }

    public Object[] readAll(Request request, Response response) {
        return getStudentService().getAllStudents();
    }

    public Student getStudentById(Request request, Response response) {
        String id = request.getHeader(Constants.Student.ID_PARAM);
        Student student = getStudentById(id);
        if(student == null) {
            throw new NotFoundException("Student with ID: " + id + " not found.");
        }
        return student;
    }

    private Student getStudentById(String id) {
        return getStudentService().getStudentById(id);
    }

    public Student createStudent(Request request, Response response){
        getValidator().validate(request);
        String requestBody = convertStreamToString(request.getBodyAsStream());
        Student student = convertJson(requestBody, Student.class);
        getValidator().validateStudent(student);

        User user = student.getUserData();
        if(user.getUserId() != null){
            User result = getUserService().getUserById(user.getUserId());
            if(result != null) {
                student.setUserData(result);
            }
        } else {
            getValidator().validateUser(user);
            getUserService().createUser(user);
        }

        if(!getStudentService().createStudent(student)){
            throw new ServiceException("Error persisiting Student. We are working on the problem.");
        }
        return student;
    }

    public User getUserByStudentId(Request request, Response response) {
        String id = request.getHeader(Constants.Student.ID_PARAM);
        Student student = getStudentById(id);
        if(student == null) {
            throw new NotFoundException("Student with ID: " + id + " not found.");
        }
        return student.getUserData();
    }
}
