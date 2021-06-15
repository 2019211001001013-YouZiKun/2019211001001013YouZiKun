
package com.YouZiKun.week4.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ConfigDemoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=getServletConfig().getInitParameter("name");
        String studentid=getServletConfig().getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("name:"+name);
        writer.println( "studentid:"+studentid);

        //next we need to tell about this servlet to tomcat - how ? - web.xml

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //when client request method is Post - here - inside doPost()

    }
}