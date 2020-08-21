package com.huadi.daoImp;

import com.huadi.dao.RegisterDao;
import com.huadi.toolUtil.C3p0Util;
import com.huadi.util.RoleInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 注册操作的数据访问层接口实现类
 * @date 2020/8/14 11:08
 */
public class RegisterDaoImp implements RegisterDao {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rst = null;
    /**
     * 查询是否已存在该用户
     * @param roleInfo
     * @return
     */
    @Override
    public boolean selectExit(RoleInfo roleInfo) throws SQLException {
        String sql="select * from user where phone=?";
        conn= C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,roleInfo.getPhoneNum());
        rst=pstm.executeQuery();
        if(rst.next()){
            C3p0Util.closeResource(rst,pstm,conn);
            return true;
        }else{
            C3p0Util.closeResource(rst,pstm,conn);
            return false;
        }
    }

    /**
     * 注册新的用户
     * @param roleInfo
     */
    @Override
    public void registerUser(RoleInfo roleInfo) throws SQLException {
        String sql="insert into user(phone,password) values(?,?)";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,roleInfo.getPhoneNum());
        pstm.setString(2,roleInfo.getPassword());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }

    /**
     * 修改密码
     * @param roleInfo
     */
    @Override
    public void updatePassword(RoleInfo roleInfo) throws SQLException {
        String sql="update user set password=? where phone=?";
        conn=C3p0Util.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,roleInfo.getPassword());
        pstm.setString(2,roleInfo.getPhoneNum());
        pstm.executeUpdate();
        C3p0Util.closeStatement(pstm);
        C3p0Util.closeConnection(conn);
    }
}
