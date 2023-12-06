package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IUserDAO;
import com.example.case_study_module3.DAO.impl.UserDAO;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
   private IUserDAO userDAO = new UserDAO();
    @Override
    public List<User> getAllList() {
        return userDAO.getAllUser();
    }

    @Override
    public User getOneList(int id) {
        return userDAO.getOneUser(id);
    }

    @Override
    public boolean addList(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public boolean editList(User user) {
        return userDAO.editUser(user);
    }

    @Override
    public boolean removeList(int id) {
        return userDAO.removeUser(id);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        User user = userDAO.getOneUser(Integer.parseInt(username));
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
