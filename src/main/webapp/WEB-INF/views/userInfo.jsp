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
<%
    User us= (User) session.getAttribute("user");
%>
<!--
<table>
    <tr><td>Username:</td><td><%//user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%//user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%//user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%//user.getGender()%></td></tr>
    <tr><td>BirthDate:</td><td><%//user.getBirthdate()%></td></tr>
</table>
-->
<table border="1">
    <tr><td>Id</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>BirthDate</td></tr>
    <%
        int i=0;
        //while
        if (us!=null) {
        out.println("<tr>"+
                "<td>"+us.getId()+"</td>" +
                "<td>"+us.getUsername()+"</td>" +
                "<td>"+us.getPassword()+"</td>"+
                "<td>"+us.getEmail()+"</td>"+
                "<td>"+us.getGender()+"</td>" +
                "<td>"+us.getBirthdate()+"</td>"+"</tr>");
        }
    %>
</table>
<a href="updateuser">update</a>
<%@ include file="footer.jsp"%>