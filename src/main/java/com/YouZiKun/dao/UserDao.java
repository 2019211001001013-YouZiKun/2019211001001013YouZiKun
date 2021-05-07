package com.YouZiKun.dao;

import com.YouZiKun.model.User;

import java.sql.*;
import java.util.*;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        Statement stmt=con.createStatement();
        int result=stmt.executeUpdate("INSERT INTO usertable VALUES("+
         user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getGender()+"','"+user.getBirthdate()+"')");

        if (result==1) return true;
        else return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        Statement stmt=con.createStatement();
        int result=stmt.executeUpdate("DELETE usertable WHERE username='"+user.getUsername()+"'");
        return result;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //todo 5.1 - write update sql where id=?
        //todo 5.2 - create prepared statement
        //todo 5.3 - executeUpdate()
        //todo 5.4 - return int

        PreparedStatement ps=con.prepareStatement("UPDATE usertable SET username=?,password=?,email=?,gender=?,birthdate=? WHERE id=? ");
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getGender());
        ps.setString(5,user.getBirthdate());
        ps.setString(6,user.getId());
        System.out.println(user.getId());
        return ps.executeUpdate();
        /*
        Statement stmt=con.createStatement();
        int result=stmt.executeUpdate("UPDATE usertable SET username='"
                +user.getUsername()+"',password='"
                +user.getUsername()+"',email='"
                +user.getEmail()+"',gender='"
                +user.getGender()+"',birthdate='"
                +user.getBirthdate()+"'" +
                "WHERE id='"+user.getId()+"'");
        return result;*/
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        PreparedStatement ps=con.prepareStatement("SELECT* FROM usertable WHERE username=? AND password=?");
        ps.setString(1,username);// function parameter
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        User user=null;
        if(rs.next()){
            //use object "user" to save one line in database.
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return user;
    }
    public List<User> findMethod(Connection con,String sql) throws  SQLException{
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        User user=null;
        List<User> users= new ArrayList<>();
        while(rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findById(Connection con, String id) throws SQLException {
        String sql="SELECT* FROM usertable WHERE username='"+id+"'";
        return findMethod(con,sql);
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="SELECT* FROM usertable WHERE username='"+username+"'";
        return findMethod(con,sql);
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="SELECT* FROM usertable WHERE password='"+password+"'";
        return findMethod(con,sql);
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="SELECT* FROM usertable WHERE email='"+email+"'";
        return findMethod(con,sql);
    }
    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="SELECT* FROM usertable WHERE ='"+gender+"'";
        return findMethod(con,sql);
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthDate) throws SQLException {
        String sql="SELECT* FROM usertable WHERE ='"+birthDate+"'";
        return findMethod(con,sql);
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="SELECT* FROM usertable";
        return findMethod(con,sql);
    }
}