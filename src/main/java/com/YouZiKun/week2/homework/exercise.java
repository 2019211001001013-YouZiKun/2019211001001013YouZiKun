package com.YouZiKun.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//now its just a java class
//extend HttpServlet
public class exercise extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println( "Name: XieYuecong");
        writer.println( "ID: 2019211001001009");
        writer.println( "Date and Time: March 15 18:00 Rainy 2021");// that all
        //next we need to tell about this servlet to tomcat - how ? - web.xml

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //when client request method is Post - here - inside doPost()

    }
}