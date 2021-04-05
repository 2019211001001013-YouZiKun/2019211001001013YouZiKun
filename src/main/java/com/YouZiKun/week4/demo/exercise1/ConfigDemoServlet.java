package com.YouZiKun.week4.demo.exercise1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = "/config",
        initParams = {
                @WebInitParam(name = "name",value = "Youzikun"),
                @WebInitParam(name = "studentId",value = "2019211001001013")
        }
)
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String studentId=config.getInitParameter("studentId");
        PrintWriter wr=response.getWriter();
        wr.println("name:"+name);
        wr.println("studentId:"+studentId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
