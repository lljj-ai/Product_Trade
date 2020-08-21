package com.huadi.daoImp;

import com.huadi.dao.IndexDao;
import com.huadi.toolUtil.C3p0Util;
import com.huadi.util.RoleInfo;

import java.sql.*;

/**
 * @author 刘杰
 * @description 登录的数据访问层实现类
 * @date 2020/8/5 11:00
 */
public class IndexDaoImp implements IndexDao {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rst = null;
    int result;
    /**
     * 数据库访问
     *
     * @param roleInfo
     * @return
     */
    @Override
    public boolean index(RoleInfo roleInfo) throws SQLException {
        String sql = "select *from user where phone=? and password=?";
        conn = C3p0Util.getConnection();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, roleInfo.getPhoneNum());
        pstm.setString(2, roleInfo.getPassword());
        rst = pstm.executeQuery();
        if (rst.next()) {
            C3p0Util.closeResource(rst,pstm,conn);
            return true;
        } else {
            C3p0Util.closeResource(rst,pstm,conn);
            return false;
        }
    }
}
