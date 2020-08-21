package com.huadi.toolUtil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/10 16:14
 */
public class C3p0Util {
    public static Connection con =null;

    private static ComboPooledDataSource dataSource  = new ComboPooledDataSource();

    public static Connection getConnection(){
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }

    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static  void closeResult(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(ResultSet rs,PreparedStatement ps,Connection con ){
        closeResult(rs);
        closeStatement(ps);
        closeConnection(con);
    }
}
