<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/12/2023
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Thông Tin Người Dùng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffe4e1;
        }

        h1 {

            margin-left: 285px;
            color: #ff1493;
        }



        form {
            background-color: #fff5ee;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
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
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ff69b4;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #ff69b4;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #ff1493;
        }
    </style>
</head>
<body>
<h1>Cập Nhật Thông Tin Người Dùng</h1>
<form action="${pageContext.request.contextPath}/user?action=editUser" method="post">
    <input type="text" id="userId" name="userId" value="${userToEdit.id}" required>

    <label for="username">Họ và Tên:</label>
    <input type="text" id="username" name="username" value="${userToEdit.username}" required><br>

    <label for="password">Mật Khẩu:</label>
    <input type="password" id="password" name="password" value="${userToEdit.password}" required><br>

    <input type="submit" value="edit">
</form>
</body>
</html>
