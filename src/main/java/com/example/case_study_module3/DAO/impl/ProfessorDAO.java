package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IProfessorDAO;
import com.example.case_study_module3.model.Professor;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IProfessorDAO {
    private final String SELECT_ALL_PROFESSOR = "SELECT * FROM professors WHERE is_delete = 0";


    @Override
    public List<Professor> getAllProfessor() {
        List<Professor> professors = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROFESSOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("professor_id");
                String name = resultSet.getString("professor_name");
                String birthday = resultSet.getString("date_of_birth");
                String id_card = resultSet.getString("ID_card");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int user_id = resultSet.getInt("user_id");
                professors.add(new Professor(id, name, birthday, id_card, phone, email, address, user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }

    @Override
    public Professor getOneProfessor(int id) {
        String SELECT_PROFESSOR_BY_ID = "SELECT * FROM professors WHERE professor_id = ? AND is_delete = 0";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROFESSOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String professorName = resultSet.getString("professor_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("ID_card");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int user_id = resultSet.getInt("user_id");
                return new Professor(id, professorName, dateOfBirth, idCard, phone, email, address,user_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean addProfessor(Professor professor) {
        String INSERT_PROFESSOR = "INSERT INTO professors (professor_name, date_of_birth, ID_card, phone_number, email, address) VALUES (?,?,?,?,?,?)";
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFESSOR);
            preparedStatement.setString(1, professor.getName());
            preparedStatement.setString(2, professor.getBirthday());
            preparedStatement.setString(3, professor.getId_card());
            preparedStatement.setString(4, professor.getPhone());
            preparedStatement.setString(5, professor.getEmail());
            preparedStatement.setString(6, professor.getAddress());

            int rowInserted = preparedStatement.executeUpdate();
            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editProfessor(Professor professor) {
        String UPDATE_PROFESSOR = "UPDATE professors SET professor_name = ?, date_of_birth = ?, ID_card = ?, phone_number = ?, email = ?, address = ? WHERE professor_id = ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFESSOR)) {

            preparedStatement.setString(1, professor.getName());
            preparedStatement.setString(2, professor.getBirthday());
            preparedStatement.setString(3, professor.getId_card());
            preparedStatement.setString(4, professor.getPhone());
            preparedStatement.setString(5, professor.getEmail());
            preparedStatement.setString(6, professor.getAddress());
            preparedStatement.setInt(7, professor.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeProfessor(int id) {
        String UPDATE_PROFESSOR_STATUS = "UPDATE professors SET is_delete = 1 WHERE professor_id = ?";

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFESSOR_STATUS)) {
            preparedStatement.setInt(1, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
