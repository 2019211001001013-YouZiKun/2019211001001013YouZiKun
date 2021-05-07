<%@ page import="com.YouZiKun.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/13
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1>User Info</h1>
12312312312312
<%
    User us= (User) session.getAttribute("user");
%>
<%%>
3212123123123123

<table border="1">
    <tr><td>Username:</td><td><%=us.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=us.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=us.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=us.getGender()%></td></tr>
    <tr><td>BirthDate:</td><td><%=us.getBirthdate()%></td></tr>
</table>
<a href="updateuser">update</a>
<%@ include file="footer.jsp"%>