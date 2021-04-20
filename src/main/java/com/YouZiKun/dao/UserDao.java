package com.YouZiKun.dao;

import com.YouZiKun.model.User;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        Statement stmt=con.createStatement();
        int result=stmt.executeUpdate("INSERT INTO usertable VALUES("+
         "'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getGender()+"','"+user.getBirthdate()+"')");

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
        Statement stmt=con.createStatement();
        int result=stmt.executeUpdate("UPDATE usertable SET username='"
                +user.getUsername()+"',password='"
                +user.getUsername()+"',email='"
                +user.getEmail()+"',gender='"
                +user.getGender()+"',birthdate='"
                +user.getBirthdate()+"'" +
                "WHERE username='"+user.getUsername()+"'");
        return result;
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
    public List<User> findMethod(Connection con,String str,String sql) throws  SQLException{
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        User user=null;
        if (rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;
    }
    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="SELECT* FROM usertable WHERE username='"+username+"'";
        return findMethod(con,username,sql);
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="SELECT* FROM usertable WHERE password='"+password+"'";
        return findMethod(con,password,sql);
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="SELECT* FROM usertable WHERE email='"+email+"'";
        return findMethod(con,email,sql);
    }
    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="SELECT* FROM usertable WHERE ='"+gender+"'";
        return findMethod(con,gender,sql);
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthDate) throws SQLException {
        String sql="SELECT* FROM usertable WHERE ='"+birthDate+"'";
        return findMethod(con,birthDate,sql);
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="SELECT* FROM usertable";
        return null;
    }
}
