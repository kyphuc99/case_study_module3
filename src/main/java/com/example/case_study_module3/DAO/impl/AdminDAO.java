package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IAdminDAO;
import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAdminDAO {
    private final String SELECT_ALL_ADMIN = "SELECT * FROM admins";
    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admins = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMIN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("admin_id");
                String name = resultSet.getString("admin_name");
                int user_id = resultSet.getInt("user_id");
                admins.add(new Admin(id, name, user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public Admin getOneAdmin(int id) {
        return null;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return false;
    }

    @Override
    public boolean editAdmin(Admin admin) {
        return false;
    }

    @Override
    public boolean removeAdmin(int id) {
        return false;
    }
}
