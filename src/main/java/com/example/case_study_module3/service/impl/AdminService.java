package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IAdminDAO;
import com.example.case_study_module3.DAO.impl.AdminDAO;
import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IAdminService;

import java.util.List;

public class AdminService implements IAdminService {
    private IAdminDAO adminDAO = new AdminDAO();

    @Override
    public List<Admin> getAllList() {
        return adminDAO.getAllAdmin();
    }

    @Override
    public Admin getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Admin object) {
        return false;
    }

    @Override
    public boolean editList(Admin object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

}
