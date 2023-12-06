package com.example.case_study_module3.DAO;

import com.example.case_study_module3.model.Student;
import com.example.case_study_module3.model.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> getAllStudent();
    Student getOneStudent (int id);
    boolean addStudent(Student student);
    boolean editStudent(Student student);
    boolean removeStudent(int id);
}
