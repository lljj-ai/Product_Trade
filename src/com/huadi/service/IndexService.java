package com.huadi.service;

import com.huadi.util.RoleInfo;

import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 登录的业务逻辑层接口
 * @date 2020/8/5 9:43
 */
public interface IndexService {
    public boolean index(RoleInfo roleInfo) throws SQLException;
}
