<%--
  Created by IntelliJ IDEA.
  User: khánh
  Date: 09/12/2022
  Time: 10:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CatalogController/search" method="post">
<input name="search" type="text" placeholder="Tìm kiếm ...">
    <input type="submit" value="Tìm Kiếm">
</form>
<table border="1">
    <thead>
    <tr>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Sex</th>
        <th>BirthDate</th>
        <th>Address</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listCatalog}" var="ct">
        <tr>
            <td>${ct.catalogId}</td>
            <td>${ct.catalogName}</td>
            <td>${ct.sex?"Nam":"Nữ"}</td>
            <td><fmt:formatDate value="${ct.birthDate}" pattern="dd/MM/yyyy"/></td>
            <td>${ct.address}</td>
            <td>${ct.catalogStatus?"Đang đi học":"Nghỉ học"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/CatalogController/initUpdate?catalogId=${ct.catalogId}">Update</a>
                <a href="<%=request.getContextPath()%>/CatalogController/delete?catalogId=${ct.catalogId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/CatalogController/initCreate"> Create New Catalog</a>
</body>
</html>
