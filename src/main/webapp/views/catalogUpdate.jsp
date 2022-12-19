<%--
  Created by IntelliJ IDEA.
  User: khánh
  Date: 12/12/2022
  Time: 10:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/CatalogController/update" method="post" >
  <table>
    <tr>
      <td>Catalog ID</td>
      <td><input type="text" name="catalogId" value="${ctUpdate.catalogId}" readonly></td>
    </tr>
    <tr>
      <td>Catalog Name</td>
      <td><input type="text" name="catalogName" value="${ctUpdate.catalogName}"></td>
    </tr>
    <tr>
      <td>Age</td>
      <td><input type="text" name="age" value="${ctUpdate.age}"></td>
    </tr>
    <tr>
      <td>Sex</td>
      <td>
        <input type="radio" name="sex" value="true" id="male" ${ctUpdate.sex?"checked":""}/><label for="male">Male</label>
        <input type="radio" name="sex" value="false" id="female" ${ctUpdate.sex?"":"checked"}/><label for="female">Female</label>
      </td>
    </tr>
    <tr>
      <td>BirthDate</td>
      <td>
        <input type="date" name="birthDate" value="${ctUpdate.birthDate}">
      </td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input type="text" NAME="address" value="${ctUpdate.address}"></td>
    </tr>
    <tr>
      <td>Status</td>
      <td>
        <select name="catalogStatus">
          <option value="true" ${ctUpdate.catalogStatus?"selected":""}>Đi học</option>
          <option value="false" ${ctUpdate.catalogStatus?"":"selected"}>Nghỉ học</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Update">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
