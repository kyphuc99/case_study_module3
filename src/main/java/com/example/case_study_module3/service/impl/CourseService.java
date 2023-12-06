package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.ICourseDAO;
import com.example.case_study_module3.DAO.impl.CourseDAO;
import com.example.case_study_module3.model.Course;
import com.example.case_study_module3.service.ICourseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourseService implements ICourseService {
    private ICourseDAO courseDAO = new CourseDAO();

    @Override
    public List<Course> getAllList() {
        return courseDAO.getAllCourse();
    }

    @Override
    public Course getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Course object) {
        return false;
    }

    @Override
    public boolean editList(Course object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

    @Override
    public void addCourse(HttpServletRequest req, HttpServletResponse resp) {


    }
}
