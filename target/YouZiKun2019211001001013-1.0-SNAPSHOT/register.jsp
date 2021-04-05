<html>
<body>
<%@ include file="header.jsp"%>
This is my JSP Page.<br><br><br>
<form method="post" action="register">
    usrname<input type="text" name="username" ><br>
    password<input type="password" name="password"><br>
    Email<input type="text" name="email"><br>
    Gender: <input type="radio" name="gender" value="Male">Male <input type="radio" name="gender" value="Female">Female<br>
    Date of Birth :<input type="text name=" name="birthDate"><br>
    <input type="submit" value="Register">
</form>
<%@ include file="footer.jsp"%>
</body>

</html>