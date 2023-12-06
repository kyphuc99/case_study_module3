package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.Class;
import com.example.case_study_module3.service.IClassService;
import com.example.case_study_module3.service.impl.ClassService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassServlet", value = "/classes")
public class ClassServlet extends HttpServlet {
    private IClassService classService = new ClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
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
                listClass(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listClass(HttpServletRequest req, HttpServletResponse resp) {
        List<Class> classes = classService.getAllList();
        try {
            req.setAttribute("classList",classes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/classes/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
