package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IStudentDAO;
import com.example.case_study_module3.model.Student;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private final String SELECT_ALL_STUDENT = "SELECT * FROM students WHERE is_delete = 0";

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                String birthday = resultSet.getString("date_of_birth");
                String id_card = resultSet.getString("id_card");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int user_id = resultSet.getInt("user_id");
                students.add(new Student(id, name, birthday, id_card, phone, email, address, user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getOneStudent(int id) {
        String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE student_id = ? AND is_delete = 0";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String studentName = resultSet.getString("student_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("ID_card");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int user_id = resultSet.getInt("user_id");
                return new Student(id, studentName, dateOfBirth, idCard, phone, email, address, user_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        String INSERT_STUDENT = "INSERT INTO students (student_name, date_of_birth, ID_card, phone_number, email, address)" + "VALUES (?,?,?,?,?,?)";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getBirthday());
            preparedStatement.setString(3, student.getId_card());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getAddress());
//            preparedStatement.setInt(7, student.getUser_id());

            int rowInserted = preparedStatement.executeUpdate();
            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editStudent(Student student) {
        String UPDATE_STUDENT = "UPDATE students SET student_name = ?, date_of_birth = ?, ID_card = ?, phone_number = ?, email = ?, address = ? WHERE student_id = ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getBirthday());
            preparedStatement.setString(3, student.getId_card());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setInt(7, student.getId());
//            preparedStatement.setInt(8, student.getUser_id());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeStudent(int id) {
        String UPDATE_STUDENT_STATUS = "UPDATE students SET is_delete = 1 WHERE student_id = ?";

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_STATUS)) {
            preparedStatement.setInt(1, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
