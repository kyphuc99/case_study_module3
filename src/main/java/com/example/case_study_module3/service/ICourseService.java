package com.example.case_study_module3.service;

import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.Course;
import com.example.case_study_module3.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ICourseService extends IUtilService<Course> {

    void addCourse(HttpServletRequest req, HttpServletResponse resp);
}
