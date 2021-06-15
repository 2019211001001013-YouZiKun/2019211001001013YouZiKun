package com.YouZiKun.week5;

import com.YouZiKun.dao.UserDao;
import com.YouZiKun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
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
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request, response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //String id=request.getParameter("Id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String email=request.getParameter("Email");
        //String gender=request.getParameter("Gender");
        //String birthdate=request.getParameter("BirthDate");

        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    //create 3 cookies
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                    //set age of cookies
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    //add cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }
                //有效的
                //Cookie c=new Cookie("sessionid",""+user.getId());
                //c.setMaxAge(10*60);
                //response.addCookie(c);
                HttpSession session=request.getSession();
                System.out.println("Session id-->"+session.getId());
                session.setMaxInactiveInterval(30);

                session.setAttribute("user",user);//set user into request
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{//无效的
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





        //System.out.println("hello world");
      /*  String sql="select * from usertable where username=? and password=? ";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                //System.out.println(rs.getString(2)+ " "+ rs.getString(3));
                //out.println("Login Success!!!" );
                //out.println("Welcome,"+username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);//请求转发
            }
            else {
                //out.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
}
