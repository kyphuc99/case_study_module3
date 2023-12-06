<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/11/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <th>StudentName</th>
        <th>Birthday</th>
        <th>IDCard</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Add User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>
                <c:out value="${student.id}"/>
            </td>
            <td>
                <c:out value="${student.name}"/>
            </td>
            <td>
                <c:out value="${student.birthday}"/>
            </td>
            <td>
                <c:out value="${student.id_card}"/>
            </td>
            <td>
                <c:out value="${student.phone}"/>
            </td>
            <td>
                <c:out value="${student.email}"/>
            </td>
            <td>
                <c:out value="${student.address}"/>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/students" method="get">
                    <input type="hidden" name="action" value="show view edit student">
                    <input type="hidden" name="studentId" value="${student.id}">
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/students" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="studentId" value="${student.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/students" method="get">
                    <input type="hidden" name="action" value="show view add student">
                    <button type="submit" >Add Student</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
