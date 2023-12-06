package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.ICourseDAO;
import com.example.case_study_module3.DAO.IFacultieDAO;
import com.example.case_study_module3.DAO.impl.CourseDAO;
import com.example.case_study_module3.DAO.impl.FacultieDAO;
import com.example.case_study_module3.model.Facultie;
import com.example.case_study_module3.service.IFacultieService;

import java.util.List;

public class FacultieService implements IFacultieService {
    private IFacultieDAO facultieDAO = new FacultieDAO();

    @Override
    public List<Facultie> getAllList() {
        return facultieDAO.getAllFacultie();
    }

    @Override
    public Facultie getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Facultie object) {
        return false;
    }

    @Override
    public boolean editList(Facultie object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }
}