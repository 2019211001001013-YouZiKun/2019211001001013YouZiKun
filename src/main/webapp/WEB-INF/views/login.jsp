<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/4
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null))
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
%>

<form method="post" action="login">
    UserName: <input type="text" name="UserName"><br>
    Password: <input type="password" name="PassWord"><br>
    <input type="submit" name="Login" value="Login">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
