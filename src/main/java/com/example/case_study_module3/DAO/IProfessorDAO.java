package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Grade;
import com.example.case_study_module3.model.Professor;
import com.example.case_study_module3.model.User;

import java.util.List;

public interface IProfessorDAO  {
    List<Professor> getAllProfessor();
    Professor getOneProfessor (int id);
    boolean addProfessor(Professor professor);
    boolean editProfessor(Professor professor);
    boolean removeProfessor(int id);
}
