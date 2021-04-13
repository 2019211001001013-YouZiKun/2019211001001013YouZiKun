<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/12
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>username</td><td>password</td><td>email</td><td>gender</td><td>birthDate</td>
    </tr>
    <%
        //get request from request attribute
        ResultSet rs= (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td> No Data!!!</td>
    </tr>
    <% }else
        while (rs.next())
            out.print("<tr>" +
                    "<td>" + rs.getString(1) + "</td>" +
                    "<td>" + rs.getString(2) + "</td>" +
                    "<td>" + rs.getString(3) + "</td>" +
                    "<td>" + rs.getString(4) + "</td>" +
                    "<td>" + rs.getString(5) + "</td>" +
                    "</tr>");
        // we will get data in next demo - 6. LiveDemo #3
    %>
</table>
<%@include file="footer.jsp"%>
