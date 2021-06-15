package com.YouZiKun.controller;

import com.YouZiKun.dao.UserDao;
import com.YouZiKun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")//url
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUserView.jsp").forward(request,response);

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

        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //Date date = ft.parse(birthdate);
            user.setBirthDate(ft.parse(birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //try {
         //   user.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(birthdate));
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}


        UserDao userDao=new UserDao();

        try {
            userDao.updateUser(con,user);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("user",user);//set user into request

            request.getRequestDispatcher("accountDetails").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
