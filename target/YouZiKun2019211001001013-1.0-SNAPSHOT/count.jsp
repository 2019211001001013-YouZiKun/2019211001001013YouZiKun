<%@ page import="org.w3c.dom.css.Counter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/3
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count JSP</title>
</head>
<body>
<!--
<% //int count=0; %>
this page has access : <% //out.println(++count); %>
-->

<!--
<%! //int count=0; %>
this page has access : <% //out.println(++count); %>
-->

<!--
<%! //int getCount(){
    //return ++count;
//} %>
<%! //int count=0; %>
the page count is now(using count()): <%//out.println(getCount()); %>
-->

<%= //Counter.getCount() %>
</body>
</html>
