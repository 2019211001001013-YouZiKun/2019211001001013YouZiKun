package com.YouZiKun.week5.demo;

import com.YouZiKun.dao.UserDao;
import com.YouZiKun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);




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
        //=数据库访问对象....
        UserDao userDao=new UserDao();
        try {
            //User user=userDao.findByUsernamePassword(con,username,password);
            List<User> users;
            users=userDao.findByPassword(con,password);
            if (users!=null){

                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",users.get(0).getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",users.get(0).getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session=request.getSession();
                System.out.println("sessionid-->"+session.getId());
                session.setMaxInactiveInterval(10);

                session.setAttribute("user",users.get(0));
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
            //userDao.saveUser(con,user);
            //userDao.deleteUser(con,user);
            //userDao.updateUser(con,user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*
        //method 4:
        PreparedStatement ps=null;
        ResultSet rs=null;
        System.out.println("Hello world");
        try {
            ps=con.prepareStatement("SELECT* FROM usertable WHERE username=? AND password=?");
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

                pw.println("<html>");
                pw.println("<style type=\"text/css\">" +
                        "font{font: italic bold 24px \"Cambria\"}" +
                        "</style>");
                pw.println("<font>");
                pw.println("Login Success !!!"+"<br>");
                pw.println("Welcome,"+username);
            }
            else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

            else {
                request.getRequestDispatcher("Login.jsp");
            }
            else pw.println("Username or Password Error!!!");
            pw.println("</font>");
            pw.println("</html>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}
