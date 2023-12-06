package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.IUserDAO;
import com.example.case_study_module3.model.Role;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String SELECT_ALL_USER = "SELECT * FROM users where is_delete = 0";
//    private static final String GET_ROLE_FROM_USER = "select * from users u " +
//            " join user_roles ur on u.username = ur.username" +
//            " join roles r on r.role_id = ur.role_id" +
//            " where u.username = ? and u.is_delete = 1;";

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                users.add(new User(id, name, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getOneUser(int id) {
        String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ? AND is_delete = 0";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                return new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role getRoleFromUser(String username) {
//        Role role = null;
//        Connection connection = JDBCConnection.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_FROM_USER);
//            preparedStatement.setString(1, username);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int roleId = resultSet.getInt("role_id");
//                String roleName = resultSet.getString("role_name");
//                role = new Role(roleId, roleName);
//            }
//            return role;
//        } catch (SQLException e) {
//            e.printStackTrace();
        return null;
    }





    @Override
    public boolean addUser(User user) {
        String INSERT_USER = "INSERT INTO users (username, password)" + "VALUES (?,?)";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            int rowInserted = preparedStatement.executeUpdate();
            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editUser(User user) {
        String UPDATE_USER = "UPDATE users SET username = ?, password = ? WHERE user_id = ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        String UPDATE_USER_STATUS = "UPDATE users SET is_delete = 1 WHERE user_id = ?";

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_STATUS)) {
            preparedStatement.setInt(1, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
