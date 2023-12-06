package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Grade;
import com.example.case_study_module3.service.IGradeService;
import com.example.case_study_module3.service.impl.GradeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GradeServlet", value = "/grades")
public class GradeServlet extends HttpServlet {
    private IGradeService gradeService = new GradeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null ){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listGrade(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listGrade(HttpServletRequest req, HttpServletResponse resp) {
        List<Grade> grades = gradeService.getAllList();
        try {
            req.setAttribute("gradeList", grades);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/grades/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
