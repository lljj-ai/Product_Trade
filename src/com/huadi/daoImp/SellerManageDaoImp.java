package com.huadi.daoImp;

import com.huadi.dao.SellerManageDao;
import com.huadi.toolUtil.C3p0Util;
import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘杰
 * @description 卖方信息管理数据访问层接口实现类
 * @date 2020/8/12 14:59
 */
public class SellerManageDaoImp implements SellerManageDao {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rst = null;

    /**
     * 对买方信息的显示
     * @param queryVo
     * @return
     * @throws SQLException
     */
    @Override
    public List<Seller> showSellers(QueryVo queryVo) throws SQLException {
        String sql="select * from seller limit ?,?";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,queryVo.getStart());
        pstm.setInt(2,queryVo.getSize());
        rst=pstm.executeQuery();
        List<Seller> list=new ArrayList<>();
        while (rst.next()){
            Seller seller=new Seller();
            seller.setUserId(rst.getInt("user_id"));
            seller.setName(rst.getString("name"));
            seller.setAge(rst.getInt("age"));
            seller.setSex(rst.getString("sex"));
            seller.setArea(rst.getString("area"));
            seller.setTel(rst.getInt("tel"));
            list.add(seller);
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return list;
    }

    /**
     * 对买方信息的添加
     * @param seller
     * @throws SQLException
     */
    @Override
    public void addSellers(Seller seller) throws SQLException {
        String sql="insert into seller(name,age,sex,area,tel) values(?,?,?,?,?)";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,seller.getName());
        pstm.setInt(2,seller.getAge());
        pstm.setString(3,seller.getSex());
        pstm.setString(4,seller.getArea());
        pstm.setInt(5,seller.getTel());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }

    /**
     * 对买方信息的修改
     * @param seller
     * @throws SQLException
     */
    @Override
    public void updateSellers(Seller seller) throws SQLException {
        String sql="update seller set name=?,age=?,sex=?,area=?,tel=? where user_id=?";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,seller.getName());
        pstm.setInt(2,seller.getAge());
        pstm.setString(3,seller.getSex());
        pstm.setString(4,seller.getArea());
        pstm.setInt(5,seller.getTel());
        pstm.setInt(6,seller.getUserId());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }

    /**
     *对买方信息的删除
     * @param seller
     * @throws SQLException
     */
    @Override
    public void deleteSellers(Seller seller) throws SQLException {
        String sql="delete from seller where user_id=?";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,seller.getUserId());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }

    /**
     * 根据id进行查询
     * @param seller
     * @return
     * @throws SQLException
     */
    @Override
    public Seller selectSellerById(Seller seller) throws SQLException {
        String sql="select * from seller where user_id=? ";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,seller.getUserId());
        rst=pstm.executeQuery();
        Seller seller1=new Seller();
        while (rst.next()){
            seller1.setUserId(rst.getInt("user_id"));
            seller1.setName(rst.getString("name"));
            seller1.setAge(rst.getInt("age"));
            seller1.setSex(rst.getString("sex"));
            seller1.setArea(rst.getString("area"));
            seller1.setTel(rst.getInt("tel"));
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return seller1;
    }

    /**
     * 查询总条数
     * @return
     * @throws SQLException
     */
    @Override
    public int totalNum() throws SQLException {
        String sql="select count(*) from seller";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        rst=pstm.executeQuery();
        int num=0;
        while (rst.next()){
            num=rst.getInt("count(*)");
        }
        return num;
    }
}
