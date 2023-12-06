package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IProfessorDAO;
import com.example.case_study_module3.DAO.IProgramDAO;
import com.example.case_study_module3.DAO.impl.ProgramDAO;
import com.example.case_study_module3.model.Program;
import com.example.case_study_module3.service.IProgramService;

import java.util.List;

public class ProgramService implements IProgramService {
    private IProgramDAO programDAO = new ProgramDAO();

    @Override
    public List<Program> getAllList() {
        return programDAO.getAllProgram();
    }

    @Override
    public Program getOneList(int id) {
        return null;
    }

    @Override
    public boolean addList(Program object) {
        return false;
    }

    @Override
    public boolean editList(Program object) {
        return false;
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }


}
