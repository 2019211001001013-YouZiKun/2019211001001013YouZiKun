package com.YouZiKun.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // redirect - same server - Relative URL
        //1. start without /
        //System.out.println("before redirect ");
        //==网页跳转  重定向》》》》》
        //http://localhost:8080/2019211001001013YouZiKun_war_exploded/redirect
        //response.sendRedirect("index.jsp"); //url- change to index.jsp
        //http://localhost:8080/2019211001001013YouZiKun_war_exploded/index.jsp
        //System.out.println("after redirect ");


        //2. start with /
        //response.sendRedirect("/2019211001001013YouZiKun_war_exploded/index.jsp"); //-???- HTTP Status 404 Not Found
        //redirect - another server - Absolute URL
        //http://localhost:8080/2019211001001013YouZiKun_war_exploded/redirect    <-----tomcat URL
        //http://localhost:8080/index.jsp
        //url change after 8080 -- means tomcat
        //add 2019211001001013YouZiKun_war_exploded/

        //redirect - another server - Abosulute URL
        //response.sendRedirect("http://www.baidu.com");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
