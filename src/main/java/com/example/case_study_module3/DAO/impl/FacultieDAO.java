package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IFacultieDAO;
import com.example.case_study_module3.model.Facultie;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultieDAO implements IFacultieDAO {
    private final String SELECT_ALL_FACULTIE = "SELECT * FROM faculties";
    @Override
    public List<Facultie> getAllFacultie() {
        List<Facultie> faculties = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACULTIE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("faculty_id");
                String name = resultSet.getString("faculty_name");
                faculties.add(new Facultie(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculties;
    }

    @Override
    public Facultie getOneFacultie(int id) {
        return null;
    }

    @Override
    public boolean addFacultie(Facultie facultie) {
        return false;
    }

    @Override
    public boolean editFacultie(Facultie facultie) {
        return false;
    }

    @Override
    public boolean removeFacultie(int id) {
        return false;
    }
}
