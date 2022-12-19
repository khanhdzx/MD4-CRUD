<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: khánh
  Date: 09/12/2022
  Time: 1:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CatalogController/create" method="post">
    <table>
        <tr>
            <td>Catalog Name</td>
            <td><input type="text" name="catalogName"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td>
                <input type="radio" name="sex" id="male"><label for="male">Male</label>
                <input type="radio" name="sex" id="female"><label for="female">Female</label>
            </td>
        </tr>
        <tr>
            <td>BirthDate</td>
            <td>
                <input type="date" name="birthDate">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" NAME="address"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td>
                <select name="catalogStatus">
                    <option value="true">Đang đi học</option>
                    <option value="false">Nghỉ học</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
