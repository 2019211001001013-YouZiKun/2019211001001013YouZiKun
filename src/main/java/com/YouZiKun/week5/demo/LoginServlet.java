package com.YouZiKun.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {

        //method 1:
        /*String driver=getServletContext().getInitParameter("driver");
        String url=getServletContext().getInitParameter("url");
        String username=getServletContext().getInitParameter("Username");
        String password=getServletContext().getInitParameter("Password");

        //method 2:
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con= (Connection) getServletContext().getAttribute("con");
        //TODO 1: GET 4 CONTEXT PARAM- DRIVER,URL,USERNAME,PASSWORD
        //TODO 2: GET JDBC connection
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {








        // TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
            //TODO 4: VALIDATE USER - SELECT * FROM USERTABLE WHERE USERNAME='xxx'
            // AND PASSWORD='YYY'
        // TODO 5: CHECK IF(USER IS VALID){
            //  OUT.PRINTLN("LOGIN SUCCESS !!!");
            //  OUT.PRINT ("WELCOME,USERNAME");
            //  }ELSE{
            //  OUT.PRINT(LOGIN ERROR!!!);
            //  }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //method 3:
        String username=request.getParameter("UserName");
        String password=request.getParameter("PassWord");
        //method 4:
        PreparedStatement ps=null;
        ResultSet rs=null;
        System.out.println("Hello world");
        try {
            ps=con.prepareStatement("SELECT* FROM usertable WHERE username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            //return 1 row ----not use while
            //PrintWriter pw=response.getWriter();
            if(rs.next()){
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));



                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
                //System.out.println("1 "+rs.getString(1));
                //System.out.println("2 "+rs.getString(2));


/*
                pw.println("<html>");
                pw.println("<style type=\"text/css\">" +
                        "font{font: italic bold 24px \"Cambria\"}" +
                        "</style>");
                pw.println("<font>");
                pw.println("Login Success !!!"+"<br>");
                pw.println("Welcome,"+username);*/
            }
            else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            /*
            else {
                request.getRequestDispatcher("Login.jsp");
            }
*/

            /*else pw.println("Username or Password Error!!!");
            pw.println("</font>");
            pw.println("</html>");*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}