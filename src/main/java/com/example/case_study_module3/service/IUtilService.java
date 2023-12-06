package com.example.case_study_module3.service;

import com.example.case_study_module3.model.User;

import java.util.List;

public interface IUtilService<E> {
    List<E> getAllList();
    E getOneList (int id);
    boolean addList (E object);
    boolean editList(E object);
    boolean removeList(int id);
}
