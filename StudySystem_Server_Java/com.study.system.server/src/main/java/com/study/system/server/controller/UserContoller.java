package com.study.system.server.controller;

import com.google.gson.GsonBuilder;
import com.study.system.server.Configuration;
import com.study.system.server.Constants;
import com.study.system.server.domain.User;
import com.study.system.server.validation.Validator;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.exception.NotFoundException;

/**
 * Created by xtreme on 4/26/15.
 */
public class UserContoller extends AbstractController {


    public UserContoller(Configuration config){
        super(new GsonBuilder().create(), new Validator(), config);
    }

    public Object[] readAll(Request request, Response response) {
        return getUserService().getAllUsers();
    }

    public String createUser(Request request, Response response) {
        getValidator().validate(request);
        String requestBody = convertStreamToString(request.getBodyAsStream());
        User user = convertJson(requestBody, User.class);
        getValidator().validateUser(user);
        createUser(user);
        return "{ \"status\": \"OK\", \"id\": " + user.getUserId() + "}";
    }

    private boolean createUser(User user){
        return getUserService().createUser(user);
    }

    public User getUserById(Request request, Response response) {
        String id = request.getHeader(Constants.User.ID_PARAM);
        User user = getUserById(id);
        if(user == null) {
            throw new NotFoundException("User with ID: " + id + " not found.");
        }
        return user;
    }

    private User getUserById(String id){
        return getUserService().getUserById(id);
    }
}
