package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.User;
import com.example.case_study_module3.model.UserRole;

import java.util.List;

public interface IUserRoleDAO {
    List<UserRole> getAllUserRole();

    UserRole getOneUserRole(int id);

    boolean addUserRole(UserRole userRole);

    boolean editUserRole(UserRole userRole);

    boolean removeUserRole(int id);
}
