<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SpringController</title>
</head>
<body>
<h1>SpringMVC index.jsp</h1>
<ul>
  <h3>入门程序</h3>
  <li> <a href="./hello">Hello SpringMVC</a></li>


  <h3>一、@RequestMapping</h3>
  <li>1.1 <a href="./RequestMappingElementType">RequestMappingElementType：Method</a></li>
  <li>1.1 <a href="./TypePath/RequestMappingElementType">RequestMappingElementType：Type</a></li>

  <li>1.2 <a href="./RequestMappingMethod">RequestMappingMethod: Get</a></li>
  <li>1.2 <form action="./RequestMappingMethod" method="post" style="display: inline">
    <input type="submit" value="RequestMappingMethod: POST"></form></li><br/>

  <li>1.3 RequestMapping params
    <form action="./RequestMappingParams">
      <input type="text" name="username" value="tom">
      <input type="text" name="password" value="1234">
      <input type="submit" value="username!=jerry & password & !gender">
    </form>
    <form action="./RequestMappingParams">
      <input type="text" name="username" value="tom">
      <input type="text" name="password" value="1234">
      <input type="text" name="gender" value="gender">
      <input type="submit" value="username!=jerry & password & gender">
    </form></li>

  <li>1.4 <a href="./RequestMappingHeaders">RequestMapping headers != Accept-Language</a> </li><br/>

  <li>1.5 <a href="${pageContext.request.contextPath}/overload">MappingOverload1，no args </a> </li>
  <li>1.5 <a href="${pageContext.request.contextPath}/overload?username">MappingOverload2, params </a> </li>
  <li>1.5 <a href="${pageContext.request.contextPath}/overload">MappingOverload3, headers &nbsp;</a>
      headers因为浏览器都会携带，所以总能匹配</li>
  <li>1.5 <a href="${pageContext.request.contextPath}/overload/1">MappingOverload4, {@PathVariable} </a> </li>


  <h3>二、RequestData</h3>
  <li>2.1 <a href="${pageContext.request.contextPath}/RequestParam?username=tom&password=1234">Mapping RequestParam</a>
    DefaultUrlParam:username=tom&password=1234</li>

  <li>2.1 <a href="${pageContext.request.contextPath}/RequestParam?username=tom">Mapping RequestParam</a>
    DefaultUrlParam:username=tom</li>

  <li>2.2 <a href="${pageContext.request.contextPath}/RequestHeader">Mapping RequestHeader</a> </li>

  <li>2.3 <a href="${pageContext.request.contextPath}/CookieValue">Mapping CookieValue</a> </li>

  <li>2.4 POJO接收form参数
    <form action="${pageContext.request.contextPath}/POJO" method="POST">
      用户名:<input type="text" name="username" value="tom"><br/>
      密码:<input type="text" name="password" value="1234"><br/>
      邮箱:<input type="text" name="email" value="ff@ff.com"><br/>
      性别:男<input type="radio" name="gender" value="1" checked="checked">
           女<input type="radio" name="gender" value="1"><br/>
      地址:<input type="text" name="addr.province" value="四川">省<input type="text" name="addr.city" value="成都">市<br/>
      <input type="submit" value="提交">
    </form>
  </li>

  <li>2.5 <a href="${pageContext.request.contextPath}/ServletAPI">Mapping ServletAPI Instance</a> </li>


  <h3>三、REST CRUD</h3>
  <li>3.1 <a href="./RESTPathVariable/tom/1234">REST_@PathVariable</a>
    {/tom/1234}</li><br/>

  <li>3.2 <form action="${pageContext.request.contextPath}/order" method="post" style="display: inline">
    <input type="submit" value="post_REST post:Create"></form></li>

  <li>3.2 <a href="${pageContext.request.contextPath}/order/1001">get_REST get:Retrieve</a> </li>

  <li>3.2 <form action="${pageContext.request.contextPath}/order" method="post" style="display: inline">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="post_REST put:Update"></form> </li>

  <li>3.2 <form action="${pageContext.request.contextPath}/order/1002" method="post" style="display: inline">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="post_REST delete:Delete"></form> </li>


  <h3>四、ResponseData </h3>
  <li>4.1 <a href="${pageContext.request.contextPath}/ModelAndView">ModelAndView</a> </li>

  <li>4.2 <a href="${pageContext.request.contextPath}/Map">(Model)Map</a> </li>

  <li>4.3 <a href="${pageContext.request.contextPath}/Model">Model</a> </li><br/>

  <li>4.4 <a href="${pageContext.request.contextPath}/JstlView">JstlView</a> </li>

  <li>4.5 <a href="${pageContext.request.contextPath}/Redirect">RedirectView</a> </li><br/>

  <li>4.6 <a href="${pageContext.request.contextPath}/ViewController">ViewController</a> </li>


  <h3>五、Json</h3>
  <li>5 <a href="./JacksonTest"> 测试json </a> </li>


  <h3>六、Interceptors</h3>
  <li>6 <a href="interceptors">interceptors flow chain</a> </li>
</ul>
</body>
</html>
