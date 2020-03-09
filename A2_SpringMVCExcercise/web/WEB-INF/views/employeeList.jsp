<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h2 align="center">员工信息</h2>
<table align="center" border="1" cellspacing="0" width="70%">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>email</th>
    <th>gender</th>
    <th>department</th>
    <th colspan="2">operations</th>
  </tr>
  <c:forEach items="${emps}" var="emp">
    <tr align="center">
      <td>${emp.id}</td>
      <td>${emp.name}</td>
      <td>${emp.email}</td>
      <td>${emp.gender==0 ? '女' : '男'}</td>
      <td>${emp.department.name}</td>
      <td><a href="#">edit</a></td>
      <td><a href="#">delete</a></td>
    </tr>
  </c:forEach>
</table>
  <h2 align="center">NewEmployee</h2>
</body>
</html>
