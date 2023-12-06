package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IProgramDAO;
import com.example.case_study_module3.model.Program;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO implements IProgramDAO {
    private final String SELECT_ALL_PROGRAM = "SELECT * FROM programs";

    @Override
    public List<Program> getAllProgram() {
        List<Program> programs = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROGRAM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("program_id");
                String name = resultSet.getString("program_name");
                int faculty_id = resultSet.getInt("faculty_id");
                programs.add(new Program(id, name, faculty_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    @Override
    public Program getOneProgram(int id) {
        return null;
    }

    @Override
    public boolean addProgram(Program program) {
        return false;
    }

    @Override
    public boolean editProgram(Program program) {
        return false;
    }

    @Override
    public boolean removeProgram(int id) {
        return false;
    }
}
