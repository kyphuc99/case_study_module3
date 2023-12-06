package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Class;
import com.example.case_study_module3.model.Course;

import java.util.List;

public interface ICourseDAO {
    List<Course> getAllCourse();
    Course getOneCourse (int id);
    boolean addCourse(Course course);
    boolean editCourse(Course course);
    boolean removeCourse(int id);
}
