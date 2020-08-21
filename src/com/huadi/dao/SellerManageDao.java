package com.huadi.dao;

import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Seller;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘杰
 * @description 卖方信息管理数据访问层接口
 * @date 2020/8/12 14:58
 */
public interface SellerManageDao {
    /**
     *对买方信息的显示
     * @param queryVo
     * @return
     * @throws SQLException
     */
    public List<Seller> showSellers(QueryVo queryVo) throws SQLException;

    /**
     * 对买方信息的添加
     * @param seller
     * @throws SQLException
     */
    public void addSellers(Seller seller) throws SQLException;

    /**
     * 对买方信息的修改
     * @param seller
     * @throws SQLException
     */
    public void updateSellers(Seller seller) throws SQLException;

    /**
     * 对买方信息的删除
     * @param seller
     * @throws SQLException
     */
    public void deleteSellers(Seller seller) throws SQLException;

    /**
     * 根据id进行查询
     * @param seller
     * @return
     * @throws SQLException
     */
    public Seller selectSellerById(Seller seller) throws SQLException;

    /**
     * 查询总条数
     * @return
     * @throws SQLException
     */
    public int totalNum() throws SQLException;
}
