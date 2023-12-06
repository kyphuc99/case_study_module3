package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.TimeTable;
import com.example.case_study_module3.service.ITimeTableService;
import com.example.case_study_module3.service.impl.TimeTableService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TimeTableServlet" , value = "/timetables")
public class TimeTableServlet extends HttpServlet {
    private ITimeTableService timeTableService = new TimeTableService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listTimeTable(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listTimeTable(HttpServletRequest req, HttpServletResponse resp) {
        List<TimeTable> timeTables = timeTableService.getAllList();
        try {
            req.setAttribute("timetableList", timeTables);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/timetables/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
