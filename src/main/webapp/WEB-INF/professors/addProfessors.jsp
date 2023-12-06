<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/13/2023
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Thêm Giảng Viên Mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffe4e1;
        }

        h1 {
            color: #ff1493;
        }

        form {
            background-color: #fff5ee;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 0 auto;
        }

        label {
            color: #ff69b4;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ff69b4;
            border-radius: 5px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button[type="submit"] {
            background-color: #ff69b4;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #ff1493;
        }
    </style>
</head>
<body>
<h1>Thêm Giảng Viên Mới</h1>
<form action="${pageContext.request.contextPath}/professors?action=addProfessor" method="post">
    <input type="hidden" name="id" value="">

    <label for="professor_name">Họ và tên:</label>
    <input type="text" id="professor_name" name="professor_name" placeholder="Họ và tên" required><br><br>


    <label for="date_of_birth">Ngày sinh:</label>
    <input type="date" id="date_of_birth" name="date_of_birth" placeholder="Ngày sinh" required><br><br>


    <label for="ID_card">CMND:</label>
    <input type="text" id="ID_card" name="ID_card" placeholder="CMND" required><br><br>

    <label for="phone_number">Số điện thoại:</label>
    <input type="text" id="phone_number" name="phone_number" placeholder="Số điện thoại" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" placeholder="Email" required><br><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" placeholder="Địa chỉ" required><br><br>

    <button type="submit">Thêm</button>
</form>
</body>
</html>
