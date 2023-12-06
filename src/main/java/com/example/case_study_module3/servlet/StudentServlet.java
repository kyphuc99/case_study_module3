package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Student;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IStudentService;
import com.example.case_study_module3.service.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "show view add student":
                showAddStudent(req,resp);
                break;
            case "addStudent":
                addStudent(req,resp);
                break;
            case "show view edit student":
                showEditStudent(req,resp);
            case "editStudent":
                editStudent(req,resp);
                break;
            case "delete":
                removeStudent(req,resp);
                break;
            default:
                listStudent(req,resp);
        }
    }


    private void showEditStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/students/editStudents.jsp");
        req.setAttribute("student",studentService.getAllList());
        requestDispatcher.forward(req,resp);
    }

    private void showAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/students/addStudents.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idString = req.getParameter("id");
        int id = 0;
        if (idString != null && !idString.isEmpty()){
            id = Integer.parseInt(idString);
        }

        String name = req.getParameter("student_name");
        String dateOfBirth = req.getParameter("date_of_birth");
        String idCard = req.getParameter("ID_card");
        String phone = req.getParameter("phone_number");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
//        int user_id = Integer.parseInt(req.getParameter("user_id"));

        Student newStudent = new Student(id, name, dateOfBirth, idCard, phone, email, address);
        boolean success = studentService.addList(newStudent);
        if(success){
            resp.sendRedirect(req.getContextPath() + "/students?action=list");
        }else {
            resp.getWriter().write("thêm người dùng thất bại!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("addStudent".equals(action)) {
            addStudent(req, resp);
        } else if ("delete".equals(action)) {
            removeStudent(req, resp);
        } else if ("editStudent".equals(action)) {
            String idString = req.getParameter("studentId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int studentId = Integer.parseInt(idString);
                    editStudent(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("studentId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int studentId = Integer.parseInt(idString);
                Student existingStudent = studentService.getOneList(studentId);
                if (existingStudent != null) {
                    String studentName = req.getParameter("student_name");
                    String dateOfBirth = req.getParameter("date_of_birth");
                    String idCard = req.getParameter("ID_card");
                    String phone = req.getParameter("phone_number");
                    String email = req.getParameter("email");
                    String address = req.getParameter("address");

                    Student editedStudent = new Student(studentId,studentName,dateOfBirth,idCard,phone,email,address);
                    boolean success = studentService.editList(editedStudent);

                    if (success) {
                        resp.sendRedirect(req.getContextPath() + "/students?action=list");
                    } else {
                        resp.getWriter().write("Cập nhật thất bại!");
                    }
                } else {
                    resp.getWriter().write("ID người dùng không tồn tại!");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("ID không hợp lệ!");
            }
        } else {
            resp.getWriter().write("ID không được để trống!");
        }
    }

    private void removeStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("studentId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int id = Integer.parseInt(idString);
                boolean success = studentService.removeList(id);

                if (success) {
                    resp.sendRedirect(req.getContextPath() + "/students?action=list");
                } else {
                    resp.getWriter().write("Xóa học sinh thất bại!");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("ID không hợp lệ!");
            }
        }
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> students = studentService.getAllList();
        try {
            req.setAttribute("studentList", students);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/students/listStudents.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
