package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.ICourseDAO;
import com.example.case_study_module3.model.Course;
import com.example.case_study_module3.utils.JDBCConnection;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements ICourseDAO {
    private final String SELECT_ALL = "SELECT * FROM courses";
    private static final String INSERT_COURSE = "INSERT INTO courses (course_id,course_name,program_id)"+" VALUES(?,?,?)";
    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        try{
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("course_id");
                String name = resultSet.getString("course_name");
                int program_id = resultSet.getInt("program_id");
                courses.add(new Course(id, name, program_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course getOneCourse(int id) {
        return null;
    }

    @Override
    public boolean addCourse(Course course) {
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_COURSE);
            statement.setInt(1, course.getId());
            statement.setString(2, course.getCourse_name());
            statement.setInt(3, course.getProgram_id());
            int rowInserted = statement.executeUpdate();
            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editCourse(Course course) {
        return false;
    }

    @Override
    public boolean removeCourse(int id) {
        return false;
    }
}
