<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Add User</title>
</head>
<body>
<!-- SpringMVC 表单标签
  taglib : http://www.springframework.org/tags/form
  SpringForm必须进行 数据回显(key : command)，否则抛出异常 [POJO映射？]
    Neither BindingResult nor plain target object for bean name 'command' available as request attribute
  >: modelAttribute 指定回显数据(对象)
-->

<%--@elvariable id="user" type="domain.User"--%>
<form:form action="${pageContext.request.contextPath}/inputUser" method="post" modelAttribute="user">
  <!-- 判断修改操作 -->
  <c:if test="${user.id != 0}" var="flag">
    <form:hidden path="id"/>
    <input type="hidden" name="_method" value="PUT">
  </c:if>

  user_name:<form:input path="name"/><br/> <!-- path == name(Html) -->
  account:<form:select path="account.accountId" items="${requestScope.accounts}" itemLabel="accountId"
                       itemValue="accountId"><br/></form:select><br/>

  <c:if test="${flag}">
    <input type="submit" value="Update">
  </c:if>
  <c:if test="${!flag}">
    <input type="submit" value="ADD">
  </c:if>
</form:form>
</body>
</html>
