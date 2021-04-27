<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/27
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u= (User) session.getAttribute("user");
%>

<form method="post" action="updateuser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    usrname<input type="text" name="username"><br>
    password<input type="password" name="password"><br>
    Email<input type="text" name="email"><br>
    Gender:<input type="radio" name="gender" value="male" <%=u.getGender().equals("male")?"checked":""%>>Male
    <input type="radio" name="gender" value="female" <%=u.getGender().equals("female")?"checked":""%>>Female<br>
    Date of Birth :<input type="text" name="birthdate" ><br>
    <input type="submit" value="Save Changes">
</form>

<%@ include file="footer.jsp"%>