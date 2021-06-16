<%--
  Created by IntelliJ IDEA.
  User: 86153
  Date: 2021/4/24 0024
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
User s=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser"> <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->

        <input type="hidden" name="id"  value="<%=s.getId()%>" style="width: 200px;height: 25px;margin-top: 2px;background-color: antiquewhite"><br/>
        <input type="text" name="username"  value="<%=s.getUsername()%>" style="width: 200px;height: 25px;margin-top: 2px;background-color: antiquewhite"><br/>
        <input type="password" name="password"  value="<%=s.getPassword()%>" style="width: 200px;height: 25px;margin-top: 5px;background-color: antiquewhite"><br/>
        <input type="text" name="email"  value="<%=s.getEmail()%>" style="width: 200px;height: 25px;margin-top: 5px;background-color: antiquewhite"><br/>
    Gender<input type="radio" name="gender" value="male" <%="male".equals(s.getGender())?"checked":""%>>Male
        <input type="radio" name="gender" value="female"<%="female".equals(s.getGender())?"checked":""%>>Female <br/>
        <input type="text" name="birthdate"  value="<%=s.getBirthDate()%>" style="width: 200px;height: 25px;margin-top: 5px;margin-bottom: 5px;background-color: antiquewhite"><br/>
    <input type="submit" value="Save Changes" style="background-color:#ffa500;color: white;width: 100px;height: 25px;text-align: center;font-size: 15px">
</form>

<%@include file="footer.jsp"%>