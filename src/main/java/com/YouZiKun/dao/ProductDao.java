package com.YouZiKun.dao;

import com.YouZiKun.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        Product product=null;
        String sql="delete from product where ProuctId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,product.getProductId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("Category"));
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update product set ProductName=? , ProductDescription=? , picture=? , price=? , CategoryId=?  where ProductId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, instance.getProductName());
        st.setString(2, instance.getProductDescription());
        st.setBinaryStream(3, instance.getPicture());
        st.setDouble(4, instance.getPrice());
        st.setInt(5,instance.getCategoryId());
        st.setInt(6,instance.getProductId());
        st.executeUpdate();
        if (st.executeUpdate() > 0) {
            return 1;
        }
        return 0;

    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select*from Product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        Product product=new Product();
        if (rs.next()){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryID"));

        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String sql = "select*from Product where categoryId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryID"));
            list.add(product);

        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "select *from product where price>=? and price<=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setDouble(1,minPrice);
        pt.setDouble(2,maxPrice);
        ResultSet rs=pt.executeQuery();
        List<Product> list=new ArrayList<>();
        while (rs.next()){
            Product product=new Product();
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
            return list;
        }
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        try{
        String sql = "select*from product";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs=pt.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            //product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryID"));
            list.add(product);
        }
        System.out.println("successful");
        }catch(SQLException e){
            e.printStackTrace();
            }
         return  list;

    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql = "select*from product where ProductName=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,productName);
        ResultSet rs=pt.executeQuery();
        List<Product> list=new ArrayList<>();
        while (rs.next()){
            Product product=new Product();
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
            return list;
        }
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public  byte[] getPictureById(Integer productId,Connection con) throws SQLException {
        byte[] imgBytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while(rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int)blob.length());
        }
        return imgBytes;
    }
}
