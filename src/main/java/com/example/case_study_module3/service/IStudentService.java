package com.example.case_study_module3.service;

import com.example.case_study_module3.model.Student;
import com.example.case_study_module3.model.User;

import java.util.List;

public interface IStudentService extends IUtilService<Student> {
    List<Student> getAllList();
    Student getOneList (int id);
    boolean addList(Student student);
    boolean editList(Student student);
    boolean removeList(int id);
}
