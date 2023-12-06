<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/10/2023
  Time: 2:14 PM
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

        body .table > :not(caption) > * > * {
            background: none;
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
        <th>ProfessorName</th>
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
    <c:forEach var="professor" items="${professorList}">
        <tr>
            <td>
                <c:out value="${professor.id}"/>
            </td>
            <td>
                <c:out value="${professor.name}"/>
            </td>
            <td>
                <c:out value="${professor.birthday}"/>
            </td>
            <td>
                <c:out value="${professor.id_card}"/>
            </td>
            <td>
                <c:out value="${professor.phone}"/>
            </td>
            <td>
                <c:out value="${professor.email}"/>
            </td>
            <td>
                <c:out value="${professor.address}"/>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/professors" method="get">
                    <input type="hidden" name="action" value="show view edit professor">
                    <input type="hidden" name="professorId" value="${professor.id}">
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/professors" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="professorId" value="${professor.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/professors" method="get">
                    <input type="hidden" name="action" value="show view add professor">
                    <button type="submit">Add Professor</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
