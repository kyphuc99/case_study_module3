package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.User;

import java.util.List;

public interface IAdminDAO {
    List<Admin> getAllAdmin();
    Admin getOneAdmin (int id);
    boolean addAdmin(Admin admin);
    boolean editAdmin(Admin admin);
    boolean removeAdmin(int id);
}
