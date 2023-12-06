package com.example.case_study_module3.service;

import com.example.case_study_module3.model.Grade;
import com.example.case_study_module3.model.Professor;
import com.example.case_study_module3.model.User;

import java.util.List;

public interface IProfessorService extends IUtilService<Professor> {
    List<Professor> getAllList();
    Professor getOneList (int id);
    boolean addList(Professor professor);
    boolean editList(Professor professor);
    boolean removeList(int id);
}
