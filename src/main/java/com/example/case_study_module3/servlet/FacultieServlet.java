package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Facultie;
import com.example.case_study_module3.service.IFacultieService;
import com.example.case_study_module3.service.impl.FacultieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacultieServlet", value = "/faculties")
public class FacultieServlet extends HttpServlet {
    private IFacultieService facultieService = new FacultieService();

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
                listFacultie(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listFacultie(HttpServletRequest req, HttpServletResponse resp) {
        List<Facultie> faculties = facultieService.getAllList();
        try {
            req.setAttribute("facultieList", faculties);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/faculties/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
