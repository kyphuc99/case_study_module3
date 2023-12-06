package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Program;
import com.example.case_study_module3.model.TimeTable;

import java.util.List;

public interface ITimeTableDAO  {
    List<TimeTable> getAllTimeTable();
    TimeTable getOneTimeTable (int id);
    boolean addTimeTable(TimeTable timeTable);
    boolean editTimeTable(TimeTable timeTable);
    boolean removeTimeTable(int id);
}
