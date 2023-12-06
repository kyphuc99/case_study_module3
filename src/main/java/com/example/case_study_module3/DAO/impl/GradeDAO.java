package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IGradeDAO;
import com.example.case_study_module3.model.Grade;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO implements IGradeDAO {
    private final String SELECT_ALL_GRADE = "SELECT * FROM grades";
    @Override
    public List<Grade> getAllGrade() {
        List<Grade> grades = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GRADE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("grade_id");
                float grade_value = resultSet.getFloat("grade_value");
                int student_id = resultSet.getInt("student_id");
                grades.add(new Grade(id, grade_value, student_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    @Override
    public Grade getOneGrade(int id) {
        return null;
    }

    @Override
    public boolean addGrade(Grade grade) {
        return false;
    }

    @Override
    public boolean editGrade(Grade grade) {
        return false;
    }

    @Override
    public boolean removeGrade(int id) {
        return false;
    }
}
