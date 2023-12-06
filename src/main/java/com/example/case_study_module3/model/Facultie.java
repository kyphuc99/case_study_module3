package com.example.case_study_module3.model;

public class Facultie {
    private int id;
    private String faculty_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public Facultie(int id, String faculty_name) {
        this.id = id;
        this.faculty_name = faculty_name;
    }

    public Facultie(){
    }
}
