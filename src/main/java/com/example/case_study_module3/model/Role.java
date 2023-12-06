package com.example.case_study_module3.model;

public class Role {
    private int id;
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }

    public Role(int id, String name) {
        this.id = id;
        this.roleName = name;
    }

    public Role() {
    }
}
