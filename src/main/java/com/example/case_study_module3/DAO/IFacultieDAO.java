package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Course;
import com.example.case_study_module3.model.Facultie;

import java.util.List;

public interface IFacultieDAO  {
    List<Facultie> getAllFacultie();
    Facultie getOneFacultie (int id);
    boolean addFacultie(Facultie facultie);
    boolean editFacultie(Facultie facultie);
    boolean removeFacultie(int id);
}
