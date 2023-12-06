package com.example.case_study_module3.servlet;

import com.example.case_study_module3.model.Professor;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IProfessorService;
import com.example.case_study_module3.service.impl.ProfessorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProfessorServlet", value = "/professors")
public class ProfessorServlet extends HttpServlet {
    private IProfessorService professorService = new ProfessorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show view add professor":
                showAddProfessor(req, resp);
                break;
            case "addProfessor":
                addProfessor(req, resp);
                break;
            case "show view edit professor":
                showEditProfessor(req, resp);
            case "editProfessor":
                editProfessor(req, resp);
                break;
            case "delete":
                removeProfessor(req, resp);
                break;
            default:
                listProfessor(req, resp);
        }
    }



    private void showEditProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/professors/editProfessors.jsp");
        req.setAttribute("professor",professorService.getAllList());
        requestDispatcher.forward(req,resp);
    }

    private void showAddProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/professors/addProfessors.jsp");
        requestDispatcher.forward(req, resp);
    }



    private void addProfessor(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idString = req.getParameter("id");
        int id = 0;
        if (idString != null && !idString.isEmpty()) {
            id = Integer.parseInt(idString);
        }

        String name = req.getParameter("professor_name");
        String dateOfBirth = req.getParameter("date_of_birth");
        String idCard = req.getParameter("ID_card");
        String phone = req.getParameter("phone_number");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Professor newProfessor = new Professor(id, name, dateOfBirth, idCard, phone, email, address);
        boolean success = professorService.addList(newProfessor);
        if (success) {
            resp.sendRedirect(req.getContextPath() + "/professors?action=list");
        } else {
            resp.getWriter().write("thêm người dùng thất bại!");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("addProfessor".equals(action)) {
            addProfessor(req, resp);
        } else if ("delete".equals(action)) {
            removeProfessor(req, resp);
        } else if ("editProfessor".equals(action)) {
            String idString = req.getParameter("professorId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int professorId = Integer.parseInt(idString);
                    editProfessor(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }
    private void editProfessor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("professorId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int professorId = Integer.parseInt(idString);
                Professor existingProfessor = professorService.getOneList(professorId);
                if (existingProfessor != null) {
                    String professorName = req.getParameter("professor_name");
                    String dateOfBirth = req.getParameter("date_of_birth");
                    String idCard = req.getParameter("ID_card");
                    String phone = req.getParameter("phone_number");
                    String email = req.getParameter("email");
                    String address = req.getParameter("address");

                    Professor editedProfessor = new Professor(professorId,professorName,dateOfBirth,idCard,phone,email,address);
                    boolean success = professorService.editList(editedProfessor);

                    if (success) {
                        resp.sendRedirect(req.getContextPath() + "/professors?action=list");
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

    private void removeProfessor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("professorId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int id = Integer.parseInt(idString);
                boolean success = professorService.removeList(id);

                if (success) {
                    resp.sendRedirect(req.getContextPath() + "/professors?action=list");
                } else {
                    resp.getWriter().write("Xóa giảng viên thất bại!");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("ID không hợp lệ!");
            }
        }
    }



    private void listProfessor(HttpServletRequest req, HttpServletResponse resp) {
        List<Professor> professors = professorService.getAllList();
        try {
            req.setAttribute("professorList", professors);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/professors/listProfessors.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
