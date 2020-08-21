package com.huadi.serviceImp;

import com.huadi.dao.SellerManageDao;
import com.huadi.daoImp.SellerManageDaoImp;
import com.huadi.service.SellerManageService;
import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Seller;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘杰
 * @description 卖方信息管理业务逻辑层接口实现类
 * @date 2020/8/12 14:57
 */
public class SellerManageServiceImp implements SellerManageService {
    /**
     * 对买方信息的显示
     * @param queryVo
     * @return
     * @throws SQLException
     */
    @Override
    public List<Seller> showSellers(QueryVo queryVo) throws SQLException {
        SellerManageDao sellerManageDao=new SellerManageDaoImp();
        return sellerManageDao.showSellers(queryVo);
    }

    /**
     * 对买方信息的添加
     * @param seller
     * @throws SQLException
     */
    @Override
    public void addSellers(Seller seller) throws SQLException {
        SellerManageDao sellerManageDao=new SellerManageDaoImp();
        sellerManageDao.addSellers(seller);
    }

    /**
     * 对买方信息的修改
     * @param seller
     * @throws SQLException
     */
    @Override
    public void updateSellers(Seller seller) throws SQLException {
        SellerManageDao sellerManageDao=new SellerManageDaoImp();
        sellerManageDao.updateSellers(seller);
    }

    /**
     * 对买方信息的删除
     * @param seller
     * @throws SQLException
     */
    @Override
    public void deleteSellers(Seller seller) throws SQLException {
        SellerManageDao sellerManageDao=new SellerManageDaoImp();
        sellerManageDao.deleteSellers(seller);
    }

    /**
     * 根据id进行查询
     * @param seller
     * @return
     * @throws SQLException
     */
    @Override
    public Seller selectSellerById(Seller seller) throws SQLException {
        SellerManageDao sellerManageDao=new SellerManageDaoImp();
        return sellerManageDao.selectSellerById(seller);
    }

    /**
     * 查询总条数
     * @return
     * @throws SQLException
     */
    @Override
    public int totalNum() throws SQLException {
        SellerManageDao sellerManageDao=new SellerManageDaoImp();
        return sellerManageDao.totalNum();
    }
}
