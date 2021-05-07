package com.YouZiKun.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/*
@WebServlet(
        urlPatterns = "/register"
)
*/
public class RegisterServlet extends HttpServlet {
    Connection con=null; //class variable,
    @Override
    public void init() throws ServletException {
        //declare
        /*
        String driver=getServletContext().getInitParameter("driver");
        String url=getServletContext().getInitParameter("url");
        String Username=getServletContext().getInitParameter("Username");
        String Password=getServletContext().getInitParameter("Password");

        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,Username,Password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        */
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        //6.insert a row into database table "usertable" in doPost()
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO usertable (username,password,email,gender,birthDate) VALUES (?,?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, birthDate);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //response.sendRedirect("login.jsp");

        //7.select all rows from "usertable"
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT* FROM usertable");
            //use request attribute
            //set rs request attribute
           // request.setAttribute("rsname",rs);
           // request.getRequestDispatcher("userList.jsp").forward(request,response);
            response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //8.print all rows -use html <table><tr><td>

        //Print

    }
}
