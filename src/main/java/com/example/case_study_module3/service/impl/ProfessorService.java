package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IProfessorDAO;
import com.example.case_study_module3.DAO.impl.ProfessorDAO;
import com.example.case_study_module3.model.Professor;
import com.example.case_study_module3.service.IProfessorService;

import java.util.List;

public class ProfessorService implements IProfessorService {
    private IProfessorDAO professorDAO = new ProfessorDAO();

    @Override
    public List<Professor> getAllList() {
        return professorDAO.getAllProfessor();
    }

    @Override
    public Professor getOneList(int id) {
        return professorDAO.getOneProfessor(id);
    }

    @Override
    public boolean addList(Professor professor) {
        return professorDAO.addProfessor(professor);
    }

    @Override
    public boolean editList(Professor professor) {
        return professorDAO.editProfessor(professor);
    }

    @Override
    public boolean removeList(int id) {
        return professorDAO.removeProfessor(id);
    }


}
