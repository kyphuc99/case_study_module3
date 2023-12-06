package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IRoleDAO;
import com.example.case_study_module3.DAO.impl.RoleDAO;
import com.example.case_study_module3.model.Role;
import com.example.case_study_module3.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private IRoleDAO roleDAO = new RoleDAO();

    @Override
    public List<Role> getAllList() {
        return roleDAO.getAllRole();
    }

    @Override
    public Role getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Role object) {
        return false;
    }

    @Override
    public boolean editList(Role object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }
}
