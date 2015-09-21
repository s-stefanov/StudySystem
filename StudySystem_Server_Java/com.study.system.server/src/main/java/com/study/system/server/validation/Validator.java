package com.study.system.server.validation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.system.server.domain.Student;
import com.study.system.server.domain.Teacher;
import com.study.system.server.domain.User;
import org.restexpress.Format;
import org.restexpress.Request;
import org.restexpress.exception.BadRequestException;

/**
 * Created by xtreme on 5/3/15.
 */
public class Validator {
    //TODO: Extend validation

    public void validate(Request request) {
        if(!validateContentType(request, "application/json")){
            throw new BadRequestException("Format of the request must be " + Format.JSON);
        }
    }

    private boolean validateContentType(Request request, String contentType) {
        if(!request.getHeader("Content-Type").equals(contentType)){
            return false;
        }
        return true;
    }

    public void validateUser(User user) {
        if(nullOrEmpty(user.getUserName()) || nullOrEmpty(user.getPassword()) || nullOrEmpty(user.getStatus())){
            throw new BadRequestException("Null or empty field.");
        }
    }

    private boolean nullOrEmpty(Object input) {
        if(input == null) {
            return true;
        }
        if((input instanceof String) && ((String) input).trim().equals("")){
            return true;
        }
        return false;
    }

    public boolean validateTeacher(Teacher teacher) {
        return true;
    }

    public boolean validateStudent(Student student) {
        return true;
    }
}
