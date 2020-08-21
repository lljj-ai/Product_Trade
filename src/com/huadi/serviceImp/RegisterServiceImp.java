package com.huadi.serviceImp;

import com.huadi.dao.RegisterDao;
import com.huadi.daoImp.RegisterDaoImp;
import com.huadi.service.RegisterService;
import com.huadi.util.RoleInfo;

import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 注册操作的业务逻辑层接口实现类
 * @date 2020/8/14 11:02
 */
public class RegisterServiceImp implements RegisterService {

    /**
     * 查询是否已存在该用户
     * @param roleInfo
     * @return
     */
    @Override
    public boolean selectExit(RoleInfo roleInfo) throws SQLException {
        RegisterDao registerDao=new RegisterDaoImp();
        return registerDao.selectExit(roleInfo);
    }

    /**
     * 注册新的用户
     * @param roleInfo
     */
    @Override
    public void registerUser(RoleInfo roleInfo) throws SQLException {
        RegisterDao registerDao=new RegisterDaoImp();
        registerDao.registerUser(roleInfo);
    }

    /**
     * 修改密码
     * @param roleInfo
     */
    @Override
    public void updatePassword(RoleInfo roleInfo) throws SQLException {
        RegisterDao registerDao=new RegisterDaoImp();
        registerDao.updatePassword(roleInfo);
    }
}
