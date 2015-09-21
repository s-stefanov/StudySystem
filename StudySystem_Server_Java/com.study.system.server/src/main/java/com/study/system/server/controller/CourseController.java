package com.study.system.server.controller;

import com.google.gson.GsonBuilder;
import com.study.system.server.Configuration;
import com.study.system.server.validation.Validator;

/**
 * Created by xtreme on 4/26/15.
 */
public class CourseController extends AbstractController{
    public CourseController(Configuration config) {
        super(new GsonBuilder().create(), new Validator(), config);
    }
}
