package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IClassDAO;
import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.Class;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO {
    private final String SELECT_ALL_CLASS = "SELECT * FROM classes";

    @Override
    public List<Class> getAllClass() {
        List<Class> classes = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("class_id");
                String name = resultSet.getString("class_name");
                int professor_id = resultSet.getInt("professor_id");
                int program_id = resultSet.getInt("program_id");
                classes.add(new Class(id, name, professor_id, program_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }

    @Override
    public Class getOneClass(int id) {
        return null;
    }

    @Override
    public boolean addClass(Class aClass) {
        return false;
    }

    @Override
    public boolean editClass(Class aClass) {
        return false;
    }

    @Override
    public boolean removeClass(int id) {
        return false;
    }
}
