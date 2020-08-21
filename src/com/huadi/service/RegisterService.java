package com.huadi.service;

import com.huadi.util.RoleInfo;

import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 注册操作的业务逻辑层接口
 * @date 2020/8/14 10:58
 */
public interface RegisterService {
    /**
     * 查询是否已存在该用户
     * @param roleInfo
     * @return
     */
    public boolean selectExit(RoleInfo roleInfo) throws SQLException;

    /**
     * 注册新的用户
     * @param roleInfo
     */
    public void registerUser(RoleInfo roleInfo) throws SQLException;

    /**
     * 修改密码
     * @param roleInfo
     */
    public void updatePassword(RoleInfo roleInfo) throws SQLException;
}
