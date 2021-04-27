package com.YouZiKun.controller;

import com.YouZiKun.dao.UserDao;
import com.YouZiKun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UpdateUserServlet", value = "/updateuser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

        //todo 1: forward to WEB-INF/views/updateUser.jsp
        //todo 2: create one jsp page -updateUser
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");

        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthdate(birthdate);
        UserDao userDao=new UserDao();
        HttpSession session=request.getSession();
        try {
            int result=userDao.updateUser(con,user);
            if (result==0){
                System.out.println("hello world");
            }
            else{
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //todo 1: get all (6) request parameters
        //todo 2: create an object of User Model
        //todo 3: set all 6 request parameter values into user model -setXXX()
        //todo 4: create an object of UserDao
        //todo 5: Call updateUser() in UserDao

        //todo 6: forward to WEB-INF/views/userinfo.jsp
    }
}
