package com.YouZiKun.controller;

import com.YouZiKun.dao.ProductDao;
import com.YouZiKun.model.Category;
import com.YouZiKun.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
        con=(Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList= Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);

            String path="/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all parameters
        String productName=request.getParameter("productName");
        Double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription=request.getParameter("productDescription");
        //picture
        InputStream inputStream=null;
        Part filepart=request.getPart("picture");
        if(filepart!=null){
            System.out.println("file name:"+filepart.getName()+" size"+filepart.getSize()+"file type"+filepart.getContentType());
            inputStream=filepart.getInputStream();
        }
        //set into model
        Product product=new Product();
        product.setProductName(productName);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);

        //call same in dao
        ProductDao productDao=new ProductDao();
        try {
            int n=productDao.save(product,con);
            //redirect
            if(1>0){
                response.sendRedirect("productList");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
