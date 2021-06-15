package com.YouZiKun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        /*ServletContext Context=getServletContext();
        String driver=Context.getInitParameter("driver");
        String url=Context.getInitParameter("url");
        String username=Context.getInitParameter("username");
        String password=Context.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        // Servlet 服务连接器
        con=(Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //String sql ="insert into usertable(id,username,password,email,gender,birthdate)values(?,?,?,?,?,?)";
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        //PreparedStatement ps=null;
        try{
            Statement st=con.createStatement();
            String sql="insert into usertable(username,password,email,gender,birthdate)"+
                    "values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
            System.out.println("sql:"+sql);

            int n=st.executeUpdate(sql);
            System.out.println("n-->"+n);

            //sql="select id,username,password,email,gender,birthdate from usertable";
            //ResultSet rs=st.executeQuery(sql);
            //PrintWriter out=response.getWriter();
            //request attribute 请求属性
            //request.setAttribute("rsname",rs);

            //request.getRequestDispatcher("userList.jsp").forward(request,response);//请求转发
            response.sendRedirect("login");
            //System.out.println("I am in RegisterServlet-->doPost()-->after forward()");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //out.print("</table>");
        //out.print("</html>");

        //print - write into response
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
