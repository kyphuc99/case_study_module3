package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Role;
import com.example.case_study_module3.service.IRoleService;
import com.example.case_study_module3.service.impl.RoleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoleServlet", value = "/roles")
public class RoleServlet extends HttpServlet {
    private IRoleService roleService = new RoleService();

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
                listRole(req,resp);
        }
    }

    private void listRole(HttpServletRequest req, HttpServletResponse resp) {
        List<Role> roles = roleService.getAllList();
        try {
            req.setAttribute("roleList", roles);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/roles/listRole.jsp");
                dispatcher.forward(req,resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
