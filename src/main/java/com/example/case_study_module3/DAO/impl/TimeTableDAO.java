package com.example.case_study_module3.DAO.impl;

import com.example.case_study_module3.DAO.ITimeTableDAO;
import com.example.case_study_module3.model.TimeTable;
import com.example.case_study_module3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeTableDAO implements ITimeTableDAO {
    private final String SELECT_ALL_TIMETABLE = "SELECT * FROM timetables";
    @Override
    public List<TimeTable> getAllTimeTable() {
        List<TimeTable> timeTables = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SELECT_ALL_TIMETABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("timetable_id");
                String day = resultSet.getString("day_of_week");
                String start_time = resultSet.getString("start_time");
                String end_time = resultSet.getString("end_time");
                int class_id = resultSet.getInt("class_id");
                timeTables.add(new TimeTable(id,day,start_time,end_time,class_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeTables;
    }

    @Override
    public TimeTable getOneTimeTable(int id) {
        return null;
    }

    @Override
    public boolean addTimeTable(TimeTable timeTable) {
        return false;
    }

    @Override
    public boolean editTimeTable(TimeTable timeTable) {
        return false;
    }

    @Override
    public boolean removeTimeTable(int id) {
        return false;
    }


}
