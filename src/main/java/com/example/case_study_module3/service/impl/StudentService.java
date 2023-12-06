package com.example.case_study_module3.service.impl;

import com.example.case_study_module3.DAO.IStudentDAO;
import com.example.case_study_module3.DAO.impl.StudentDAO;
import com.example.case_study_module3.model.Student;
import com.example.case_study_module3.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentDAO studentDAO = new StudentDAO();

    @Override
    public List<Student> getAllList() {
        return studentDAO.getAllStudent();
    }

    @Override
    public Student getOneList(int id) {
        return studentDAO.getOneStudent(id);
    }

    @Override
    public boolean addList(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public boolean editList(Student student) {
        return studentDAO.editStudent(student);
    }

    @Override
    public boolean removeList(int id) {
        return studentDAO.removeStudent(id);
    }


}
