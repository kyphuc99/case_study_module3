package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Program;
import com.example.case_study_module3.model.Role;

import java.util.List;

public interface IRoleDAO {
    List<Role> getAllRole();
    Role getOneRole (int id);
    boolean addRole(Role role);
    boolean editRole(Role role);
    boolean removeRole(int id);
}
