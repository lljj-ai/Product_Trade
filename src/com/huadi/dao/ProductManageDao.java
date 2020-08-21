package com.huadi.dao;

import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘杰
 * @description 商品信息管理数据访问层接口
 * @date 2020/8/10 16:02
 */
public interface ProductManageDao {
    /**
     * 显示商品信息
     * @return
     */
    public List<Product> showProduct(QueryVo queryVo) throws SQLException;

    /**
     * 添加商品信息
     * @param product
     */
    public void addProduct(Product product) throws SQLException;

    /**
     * 删除商品信息
     * @param product
     */
    public void deleteProduct(Product product) throws SQLException;

    /**
     * 修改商品信息
     * @param product
     */
    public void updateProduct(Product product) throws SQLException;
    /**
     * 根据id查询商品信息
     * @param product
     */
    public  Product selectProduct(Product product) throws SQLException;

    /**
     * 查询总的记录数
     * @return
     */
    public int totalNum() throws SQLException;

}
