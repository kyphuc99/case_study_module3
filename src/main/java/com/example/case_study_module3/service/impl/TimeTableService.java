package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.ITimeTableDAO;
import com.example.case_study_module3.DAO.impl.TimeTableDAO;
import com.example.case_study_module3.model.TimeTable;
import com.example.case_study_module3.service.ITimeTableService;

import java.util.List;

public class TimeTableService implements ITimeTableService {
    private ITimeTableDAO timeTableDAO = new TimeTableDAO();
    @Override
    public List getAllList() {
        return timeTableDAO.getAllTimeTable();
    }

    @Override
    public TimeTable getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(TimeTable object) {
        return false;
    }

    @Override
    public boolean editList(TimeTable object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }


}
