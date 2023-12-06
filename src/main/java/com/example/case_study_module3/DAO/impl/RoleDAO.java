package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IRoleDAO;
import com.example.case_study_module3.model.Role;
import com.example.case_study_module3.utils.JDBCConnection;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {
    private final String SELECT_ALL_ROLE = "SELECT * FROM roles";
    @Override
    public List<Role> getAllRole() {
        List<Role> roles = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("role_id");
                String name = resultSet.getString("role_name");
                roles.add(new Role(id,name));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role getOneRole(int id) {
        return null;
    }

    @Override
    public boolean addRole(Role role) {
        return false;
    }

    @Override
    public boolean editRole(Role role) {
        return false;
    }

    @Override
    public boolean removeRole(int id) {
        return false;
    }
}
