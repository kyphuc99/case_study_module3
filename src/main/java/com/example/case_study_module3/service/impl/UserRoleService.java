package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IUserRoleDAO;
import com.example.case_study_module3.DAO.impl.UserRoleDAO;
import com.example.case_study_module3.model.UserRole;
import com.example.case_study_module3.service.IUserRoleService;

import java.util.List;

public class UserRoleService implements IUserRoleService {
    private IUserRoleDAO userRoleDAO = new UserRoleDAO();

    @Override
    public List getAllList() {
        return null;
    }

    @Override
    public Object getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Object object) {
        return false;
    }

    @Override
    public boolean editList(Object object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }
}
