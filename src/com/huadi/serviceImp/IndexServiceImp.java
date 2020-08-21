package com.huadi.serviceImp;


import com.huadi.dao.IndexDao;
import com.huadi.daoImp.IndexDaoImp;
import com.huadi.service.IndexService;
import com.huadi.util.RoleInfo;

import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 登录的业务逻辑层实现类
 * @date 2020/8/5 9:43
 */
public class IndexServiceImp implements IndexService {

    @Override
    public boolean index(RoleInfo roleInfo) throws SQLException {
        IndexDao indexDao = new IndexDaoImp();
        return indexDao.index(roleInfo);
    }
}
