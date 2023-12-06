package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IUserRoleDAO;
import com.example.case_study_module3.model.UserRole;

import java.util.List;

public class UserRoleDAO implements IUserRoleDAO {
    @Override
    public List<UserRole> getAllUserRole() {
        return null;
    }

    @Override
    public UserRole getOneUserRole(int id) {
        return null;
    }

    @Override
    public boolean addUserRole(UserRole userRole) {
        return false;
    }

    @Override
    public boolean editUserRole(UserRole userRole) {
        return false;
    }

    @Override
    public boolean removeUserRole(int id) {
        return false;
    }
}
