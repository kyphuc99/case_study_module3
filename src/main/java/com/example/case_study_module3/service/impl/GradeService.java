package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IGradeDAO;
import com.example.case_study_module3.DAO.impl.GradeDAO;
import com.example.case_study_module3.model.Grade;

import com.example.case_study_module3.service.IGradeService;

import java.util.List;

public class GradeService implements IGradeService {
    private IGradeDAO gradeDAO = new GradeDAO();

    @Override
    public List<Grade> getAllList() {
        return gradeDAO.getAllGrade();
    }

    @Override
    public Grade getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Grade object) {
        return false;
    }

    @Override
    public boolean editList(Grade object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

}
