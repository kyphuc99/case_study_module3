package com.example.case_study_module3.service.impl;


import com.example.case_study_module3.DAO.IClassDAO;
import com.example.case_study_module3.DAO.impl.ClassDAO;
import com.example.case_study_module3.model.Class;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IClassService;

import java.util.List;

public class ClassService implements IClassService {
   private IClassDAO classDAO = new ClassDAO();

    @Override
    public List<Class> getAllList() {
        return classDAO.getAllClass();
    }

    @Override
    public Class getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Class object) {
        return false;
    }

    @Override
    public boolean editList(Class object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }


}
