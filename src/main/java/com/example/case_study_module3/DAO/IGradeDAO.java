package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Facultie;
import com.example.case_study_module3.model.Grade;

import java.util.List;

public interface IGradeDAO {
    List<Grade> getAllGrade();
    Grade getOneGrade (int id);
    boolean addGrade(Grade grade);
    boolean editGrade(Grade grade);
    boolean removeGrade(int id);
}
