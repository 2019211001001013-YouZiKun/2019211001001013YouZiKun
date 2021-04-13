<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>
<%@ include file="header.jsp"%>
<h1>Welcome to my home page.</h1>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<a href="hello-servlet">Hello Servlet-week1</a><br>
<a href="hello">Student info Servlet-week2</a><br>
<a href="life">Life Cycle Servlet-week3</a><br>
<a href="register.jsp">Register-getParameter-week3</a><br>
<a href="config">Config parameter-week4</a><br>
<a href="register.jsp">Register JDBC-week4</a><br>
<a href="index.jsp">include-week5</a><br>
<a href="login.jsp">Login-week5</a>

<%@ include file="footer.jsp"%>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>