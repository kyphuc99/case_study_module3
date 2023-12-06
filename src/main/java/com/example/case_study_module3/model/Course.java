package com.example.case_study_module3.model;

public class Course {
    private int id;
    private String course_name;
    private int program_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public Course(int id, String course_name, int program_id) {
        this.id = id;
        this.course_name = course_name;
        this.program_id = program_id;
    }

    public Course() {
    }
}
