<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>List</title>
  <%-- 默认静态资源被 DispatcherServlet 处理
        需要改为由tomcat处理 <mvc:default-servlet-handler>
  --%>
  <script src="scripts/jquery-3.4.1.js" type="text/javascript"></script>
  <script type="text/javascript">
      $(function () {
          // REST delete
          $(".del").click(function () {
              var flag = window.confirm("删除用户?");
              if (!flag) {
                  return false
              }
              var href = $(this).attr("href");
              $("#hiddenForm>:first-child").attr("value", "DELETE");
              $("#hiddenForm").attr("action", href).submit();
              // 取消anchor的默认行为
              return false;
          });
      });

  </script>
</head>
<body>
<h1 align="center">用户信息列表</h1>
<table border="1px" align="center" width="70%" cellspacing="0px">
  <tr>
    <th>user_id</th>
    <th>user_name</th>
    <th>account_name</th>
    <th>account_money</th>
    <th colspan="2">operation</th>
  </tr>

  <c:forEach items="${users}" var="user">
    <tr align="center">
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.account.accountId}</td> <!-- 级联访问 -->
      <td>${user.account.money}</td>
      <td><a class="update" href="inputUser/${user.id}">edit</a></td>
      <td><a class="del" href="listAllUser/${user.id}">delete</a></td>
    </tr>
  </c:forEach>
</table>

<form id="hiddenForm" action="" method="post">
  <input type="hidden" name="_method" value="">
</form>

<h3 align="center"><a href="./inputUser"> 添加用户 </a></h3>

</body>
</html>
