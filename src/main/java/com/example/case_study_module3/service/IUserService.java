package com.example.case_study_module3.service;

import com.example.case_study_module3.model.User;

import java.util.List;

public interface IUserService extends IUtilService<User>{
    List<User> getAllList();
    User getOneList (int id);
    boolean addList(User user);
    boolean editList(User user);
    boolean removeList(int id);
    boolean checkLogin(String username, String password);
}
