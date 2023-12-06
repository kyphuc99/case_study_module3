<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/11/2023
  Time: 1:46 PM
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
        <th>Day_of_week</th>
        <th>Start_time</th>
        <th>End_time</th>
        <th>Class_id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="timetable" items="${timetableList}">
        <tr>
            <td>
                <c:out value="${timetable.id}"/>
            </td>
            <td>
                <c:out value="${timetable.day_of_week}"/>
            </td>
            <td>
                <c:out value="${timetable.start_time}"/>
            </td>
            <td>
                <c:out value="${timetable.end_time}"/>
            </td>
            <td>
                <c:out value="${timetable.class_id}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
