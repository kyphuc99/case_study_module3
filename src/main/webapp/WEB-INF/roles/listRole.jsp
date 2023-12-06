<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/12/2023
  Time: 4:27 PM
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
        <th>ID</th>
        <th>RoleName</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="role" items="${roleList}">
        <tr>
            <td>
                <c:out value="${role.id}"/>
            </td>
            <td>
                <c:out value="${role.name}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
