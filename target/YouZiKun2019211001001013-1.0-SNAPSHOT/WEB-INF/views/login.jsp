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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if (allCookies!=null){
        for (Cookie c: allCookies) {
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    UserName: <input type="text" name="UserName" value="<%=username%>"><br>
    Password: <input type="password" name="PassWord" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked>RememeberMe<br>
    <input type="submit" name="Login" value="Login">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
