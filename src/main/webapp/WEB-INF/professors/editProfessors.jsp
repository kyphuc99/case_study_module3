<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/15/2023
  Time: 4:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Thông Tin Giảng Viên</title>
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
<h1>Cập Nhật Thông Tin Giảng Viên</h1>
<form action="${pageContext.request.contextPath}/professors?action=editProfessor" method="post">
    <label for="professorId">Nhập STT</label>
    <input type="text" id="professorId" name="professorId" value="${professorToEdit.id}" required>

    <label for="professor_name">Họ và Tên:</label>
    <input type="text" id="professor_name" name="professor_name" value="${professorToEdit.name}" required><br>

    <label for="date_of_birth">Ngày sinh:</label>
    <input type="date" id="date_of_birth" name="date_of_birth" value="${professorToEdit.dateOfBirth}" required><br>

    <label for="ID_card">CMND:</label>
    <input type="text" id="ID_card" name="ID_card" value="${professorToEdit.idCard}" required><br>

    <label for="phone_number">Số điện thoại:</label>
    <input type="text" id="phone_number" name="phone_number" value="${professorToEdit.phone}" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${professorToEdit.email}" required><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" value="${professorToEdit.address}" required><br>

    <input type="submit" value="edit">
</form>
</body>
</html>
