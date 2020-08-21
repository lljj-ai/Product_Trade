package com.huadi.daoImp;

import com.huadi.dao.ProductManageDao;
import com.huadi.toolUtil.C3p0Util;
import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘杰
 * @description 商品信息管理数据访问层接口实现类
 * @date 2020/8/10 16:03
 */
public class ProductManageDaoImp implements ProductManageDao {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rst = null;
    /**
     * 商品信息显示
     * @return
     */
    @Override
    public List<Product> showProduct(QueryVo queryVo) throws SQLException {
        String sql="SELECT * FROM `product` limit ?,?";
        conn= C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,queryVo.getStart());
        pstm.setInt(2,queryVo.getSize());
        rst=pstm.executeQuery();
        List<Product> list=new ArrayList<>();
        while (rst.next()){
            Product product=new Product();
            product.setProductId(rst.getInt("product_id"));
            product.setProductName(rst.getString("product_name"));
            product.setCostPrice(rst.getInt("cost_price"));
            product.setSellingPrice(rst.getInt("selling_price"));
            product.setManufacture(rst.getString("manufacture"));
            list.add(product);
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return list;
    }

    /**
     * 添加商品信息
     * @param product
     */
    @Override
    public void addProduct(Product product) throws SQLException{
        String sql="INSERT INTO product(product_name,cost_price,selling_price,manufacture) VALUES(?,?,?,?);";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,product.getProductName());
        pstm.setInt(2,product.getCostPrice());
        pstm.setInt(3,product.getSellingPrice());
        pstm.setString(4,product.getManufacture());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }


    /**
     * 删除指定的商品信息
     * @param product
     */
    @Override
    public void deleteProduct(Product product) throws SQLException{
        String sql="delete from product where product_id=?";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,product.getProductId());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }

    /**
     * 根据id修改相应的商品信息
     * @param product
     */
    @Override
    public void updateProduct(Product product) throws SQLException{
        String sql="UPDATE product SET product_name=?,cost_price=?,selling_price=?,manufacture=? WHERE product_id=?; ";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,product.getProductName());
        pstm.setInt(2,product.getCostPrice());
        pstm.setInt(3,product.getSellingPrice());
        pstm.setString(4,product.getManufacture());
        pstm.setInt(5,product.getProductId());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }

    /**
     * 根据id查询相应商品信息
     * @param product
     * @return
     * @throws SQLException
     */
    @Override
    public Product selectProduct(Product product)throws SQLException {
        String sql="select * from product where product_id=?";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,product.getProductId());
        rst=pstm.executeQuery();
        Product product1=new Product();
        while (rst.next()){
            product1.setProductId(product.getProductId());
            product1.setProductName(rst.getString("product_name"));
            product1.setCostPrice(rst.getInt("cost_price"));
            product1.setSellingPrice(rst.getInt("selling_price"));
            product1.setManufacture(rst.getString("manufacture"));
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return product1;
    }

    /**
     * 查询记录总数
     * @return
     * @throws SQLException
     */
    @Override
    public int totalNum()throws SQLException {
        String sql="select count(*) from product";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        rst=pstm.executeQuery();
        int num=0;
        while (rst.next()){
            num=rst.getInt("count(*)");
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return num;
    }

}
