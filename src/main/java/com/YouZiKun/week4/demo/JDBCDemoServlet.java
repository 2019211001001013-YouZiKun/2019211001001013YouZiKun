package com.YouZiKun.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

 /*@WebServlet(
        urlPatterns  ={"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQlServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb;"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456")
        },loadOnStartup = 1
)*/

public class
JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        //connect only once
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//its SQLServerDriver
        //String url="jdbc:sqlserver://localhost;databaseName=userdb;";
        //String username="sa";
        //String password="123456";
        //System.out.println("hello world");
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //connect many times--bad way


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //print - write into response
        String sql="select * from usertable";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while(rs.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
