package com.example.case_study_module3.model;

public class Grade {
    private int id;
    private float grade_value;
    private int student_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGrade_value() {
        return grade_value;
    }

    public void setGrade_value(float grade_value) {
        this.grade_value = grade_value;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Grade(int id, float grade_value, int student_id) {
        this.id = id;
        this.grade_value = grade_value;
        this.student_id = student_id;
    }

    public Grade() {
    }
}
