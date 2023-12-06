package com.example.case_study_module3.servlet;

import com.example.case_study_module3.DAO.IRoleDAO;
import com.example.case_study_module3.DAO.IUserRoleDAO;
import com.example.case_study_module3.DAO.impl.RoleDAO;
import com.example.case_study_module3.model.User;
import com.example.case_study_module3.service.IRoleService;
import com.example.case_study_module3.service.IUserRoleService;
import com.example.case_study_module3.service.IUserService;
import com.example.case_study_module3.service.impl.RoleService;
import com.example.case_study_module3.service.impl.UserRoleService;
import com.example.case_study_module3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
//    private IUserRoleService userRoleService = new UserRoleService();
//    private IRoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "show view add user":
                showAddUser(req,resp);
                break;
            case "addUser":
                addUser(req,resp);
                break;
            case "show view edit user":
                showEditUser(req,resp);
            case "editUser":
                editUser(req,resp);
                break;
            case "delete":
                removeUser(req,resp);
                break;
            default:
                listUser(req,resp);
        }
    }

    private void showEditUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/user/editUser.jsp");
        req.setAttribute("user",userService.getAllList());
        requestDispatcher.forward(req,resp);
    }

    private void showAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/user/addUser.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String idString = req.getParameter("id");
        int id = 0;
        if (idString != null && !idString.isEmpty()){
            id = Integer.parseInt(idString);
        }

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        User newUser = new User(id,name,password);
        boolean success = userService.addList(newUser);
        if(success){
            resp.sendRedirect(req.getContextPath() + "/user?action=list");
        }else {
            resp.getWriter().write("thêm người dùng thất bại!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("addUser".equals(action)) {
            addUser(req, resp);
        } else if ("delete".equals(action)) {
            removeUser(req, resp);
        } else if ("editUser".equals(action)) {
            String idString = req.getParameter("userId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int userId = Integer.parseInt(idString);
                    editUser(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("userId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int userId = Integer.parseInt(idString);
                User existingUser = userService.getOneList(userId);
                if (existingUser != null) {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");
                    User editedUser = new User(userId,username,password);
                    boolean success = userService.editList(editedUser);

                    if (success) {
                        resp.sendRedirect(req.getContextPath() + "/user?action=list");
                    } else {
                        resp.getWriter().write("Cập nhật người dùng thất bại!");
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

    private void removeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idString = req.getParameter("userId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int id = Integer.parseInt(idString);
                boolean success = userService.removeList(id);

                if (success) {
                    resp.sendRedirect(req.getContextPath() + "/user?action=list");
                } else {
                    resp.getWriter().write("Xóa người dùng thất bại!");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("ID không hợp lệ!");
            }
        }
    }


    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("userList",userService.getAllList());
//            req.setAttribute("roleList",roleService.getAllList());
//            req.setAttribute("userRoleList",userRoleService.getAllList());
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/user/listUser.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
