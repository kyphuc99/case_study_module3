package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Role;
import com.example.case_study_module3.model.User;

import java.util.List;

public interface IUserDAO  {
    List<User> getAllUser();
    User getOneUser (int id);
    Role getRoleFromUser(String username);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean removeUser(int id);
}
