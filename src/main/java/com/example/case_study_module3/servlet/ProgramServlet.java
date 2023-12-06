package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Program;
import com.example.case_study_module3.service.IProgramService;
import com.example.case_study_module3.service.impl.ProgramService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProgramServlet", value = "/programs")
public class ProgramServlet extends HttpServlet {
    private IProgramService programService = new ProgramService();

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
                listProgram(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listProgram(HttpServletRequest req, HttpServletResponse resp) {
        List<Program> programs = programService.getAllList();
        try {
            req.setAttribute("programList", programs);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/programs/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
