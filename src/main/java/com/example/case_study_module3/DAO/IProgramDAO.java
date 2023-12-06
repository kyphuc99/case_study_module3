package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Professor;
import com.example.case_study_module3.model.Program;

import java.util.List;

public interface IProgramDAO  {
    List<Program> getAllProgram();
    Program getOneProgram (int id);
    boolean addProgram(Program program);
    boolean editProgram(Program program);
    boolean removeProgram(int id);
}
