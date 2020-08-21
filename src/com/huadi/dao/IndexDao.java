package com.huadi.dao;

import com.huadi.util.RoleInfo;

import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 登录的数据访问层接口
 * @date 2020/8/5 10:59
 */
public interface IndexDao {
    public boolean index(RoleInfo roleInfo) throws SQLException;
}
