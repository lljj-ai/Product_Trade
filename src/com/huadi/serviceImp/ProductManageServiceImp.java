package com.huadi.serviceImp;

import com.huadi.dao.ProductManageDao;
import com.huadi.daoImp.ProductManageDaoImp;
import com.huadi.service.ProductManageService;
import com.huadi.service.ProductTradeService;
import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘杰
 * @description 商品信息管理业务逻辑层接口实现类
 * @date 2020/8/10 15:59
 */
public class ProductManageServiceImp implements ProductManageService {
    /**
     * 商品信息显示
     * @return
     */
    @Override
    public List<Product> showProduct(QueryVo queryVo) throws SQLException {
        ProductManageDao productManageDao=new ProductManageDaoImp();
        return productManageDao.showProduct(queryVo);
    }

    /**
     * 添加商品操作
     * @param product
     * @throws SQLException
     */
    @Override
    public void addProduct(Product product)throws SQLException {
        ProductManageDao productManageDao=new ProductManageDaoImp();
        productManageDao.addProduct(product);
    }

    /**
     * 删除指定的商品
     * @param product
     */
    @Override
    public void deleteProduct(Product product)throws SQLException {
        ProductManageDao productManageDao=new ProductManageDaoImp();
        productManageDao.deleteProduct(product);
    }

    /**
     * 根据id进行更新操作
     * @param product
     */
    @Override
    public void updateProduct(Product product) throws SQLException{
        ProductManageDao productManageDao=new ProductManageDaoImp();
        productManageDao.updateProduct(product);
    }

    /**
     * 根据id查询商品信息
     * @param product
     */
    @Override
    public Product selectProduct(Product product)throws SQLException {
        ProductManageDao productManageDao=new ProductManageDaoImp();
        return productManageDao.selectProduct(product);
    }

    /**
     * 查询总的记录数
     * @return
     * @throws SQLException
     */
    @Override
    public int totalNum() throws SQLException {
        ProductManageDao productManageDao=new ProductManageDaoImp();
        return productManageDao.totalNum();
    }
}
