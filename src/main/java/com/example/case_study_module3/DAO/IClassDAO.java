package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Class;
import com.example.case_study_module3.model.User;

import java.util.List;

public interface IClassDAO {
    List<Class> getAllClass();
    Class getOneClass (int id);
    boolean addClass(Class object);
    boolean editClass(Class object);
    boolean removeClass(int id);
}
