package com.example.case_study_module3.model;

public class Program {
    private int id;
    private String name;
    private int faculty_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public Program(int id, String name, int faculty_id) {
        this.id = id;
        this.name = name;
        this.faculty_id = faculty_id;
    }

    public Program() {
    }
}
