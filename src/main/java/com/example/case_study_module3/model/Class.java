package com.example.case_study_module3.model;

public class Class {
    private int id;
    private String name;
    private int professor_id;
    private int program_id;

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

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public Class(int id, String name, int professor_id, int program_id) {
        this.id = id;
        this.name = name;
        this.professor_id = professor_id;
        this.program_id = program_id;
    }

    public Class(){
    }
}
