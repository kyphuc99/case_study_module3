package com.example.case_study_module3.servlet;

import com.example.case_study_module3.DAO.ICourseDAO;
import com.example.case_study_module3.model.Admin;
import com.example.case_study_module3.model.Course;
import com.example.case_study_module3.service.ICourseService;
import com.example.case_study_module3.service.impl.CourseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseServlet", value = "/courses")
public class CourseServlet extends HttpServlet {
    private ICourseService courseService = new CourseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCourse(req,resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listCourse(req,resp);
        }
    }

    private void createCourse(HttpServletRequest req, HttpServletResponse resp) {
        String idString = req.getParameter("id");
        int id = 0;
        if (idString != null && !idString.isEmpty()){
            id = Integer.parseInt(idString);
        }
        String name = req.getParameter("course_name");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listCourse(HttpServletRequest req, HttpServletResponse resp) {
        List<Course> courses = courseService.getAllList();
        try {
            req.setAttribute("courseList",courses);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/courses/list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }    }
}
