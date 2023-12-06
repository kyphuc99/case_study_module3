<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/7/2023
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: #ffffff; /* Màu nền cho trang web */
        }

        .table {
            width: 100%;
            border-collapse: collapse;
        }

        .table thead th {
            background-color: #ffcccc; /* Màu nền cho phần đầu bảng */
            padding: 10px;
            text-align: left;
        }

        .table tbody td {
            padding: 10px;
            text-align: left;
        }

        .table-success {
            background-color: #ffe6f0; /* Màu nền cho bảng */
        }
    </style>
</head>
<body>
<table class="table table-success table-stripped">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Add User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.name}"/>
            </td>
            <td>
                <c:out value="${user.password}"/>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/user" method="get">
                    <input type="hidden" name="action" value="show view edit user">
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/user" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/user" method="get">
                    <input type="hidden" name="action" value="show view add user">
                    <button type="submit" >Add User</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
