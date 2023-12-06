package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IAdminService;
import com.example.case_study_module3.service.impl.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admins")
public class AdminServlet extends HttpServlet {
    private IAdminService adminService = new AdminService();
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
                listAdmin(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listAdmin(HttpServletRequest req, HttpServletResponse resp) {
        List<Admin> admins = adminService.getAllList();
        try {
            req.setAttribute("adminList",admins);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/admins/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
