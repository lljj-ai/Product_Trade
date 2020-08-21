package com.huadi.daoImp;

import com.huadi.dao.ProductTradeDao;
import com.huadi.toolUtil.C3p0Util;
import com.huadi.util.TradeInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘杰
 * @description 交易信息显示数据访问层实现类
 * @date 2020/8/10 15:37
 */
public class ProductTradeDaoImp implements ProductTradeDao {
    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rst=null;
    /**
     * 交易信息查询
     * @return
     */
    @Override
    public List<TradeInfo> tradeProduct() throws SQLException {
        List<TradeInfo> list=new ArrayList<>();
        List<Integer> list1=tradeTimesOther();
        Object[] objects=list1.toArray();
        for(int i=0;i<objects.length;i++){
            TradeInfo tradeInfo=new TradeInfo();
            tradeInfo.setProductId((int)objects[i]);
            tradeInfo.setProductName(queryName((int)objects[i]));
            tradeInfo.setTradeNumber(count((int)objects[i]));
            list.add(tradeInfo);
        }
        return list;
    }

    /**
     * 通过商品id查询各个交易次数
     * @return
     */
    @Override
    public List<Integer> tradeTimes()throws SQLException {
        List<Integer> list1;
        List<Integer> list=new ArrayList<>();
        list1=tradeTimesOther();
        Object[] array=list1.toArray();
        conn= C3p0Util.getConnection();
        String sql="SELECT count(*) from tradeinfo where product_id=?";
        pstm=conn.prepareStatement(sql);
        for(int i=0;i<array.length;i++){
            pstm.setInt(1,(int)array[i]);
            rst=pstm.executeQuery();
            while(rst.next()) {
                list.add(rst.getInt("count(*)"));
            }
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return list;
    }

    /**
     * 查询商品id
     * @param
     * @return
     * @throws SQLException
     */
    public  List<Integer> tradeTimesOther()throws SQLException{
       /* Object[] array=list2.toArray();
        List<Integer> list=new ArrayList<>();
        conn= C3p0Util.getConnection();
        String sql="SELECT count(*) from tradeinfo where product_id=?";
        pstm=conn.prepareStatement(sql);*/
        //Iterator<Integer> iterator=list.iterator();
/*        while(iterator.hasNext()){
            pstm.setInt(1,iterator.next());
            rst=pstm.executeQuery();
            while(rst.next()) {
                list.add(rst.getInt("count(*)"));
            }
        }*/
        /*for(int i=0;i<array.length;i++){
            pstm.setInt(1,(int)array[i]);
            rst=pstm.executeQuery();
            while(rst.next()) {
                list.add(rst.getInt("count(*)"));
            }
        }
        C3p0Util.closeResource(rst,pstm,conn);*/
        List<Integer> list=new ArrayList<>();
        String sql="SELECT product_id from product;";
        conn= C3p0Util.getConnection();
        pstm= conn.prepareStatement(sql);
        rst=pstm.executeQuery();
        while (rst.next()){
            list.add(rst.getInt("product_id"));
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return list;
    }

    /**
     * 交易利润查询
     * @return
     */
    @Override
    public List<Integer> tradeProfit() throws SQLException{
        List<Integer> list1=tradeTimesOther();
        Object[] array1=  list1.toArray();
        List<Integer> list=new ArrayList<>();
/*        while(iterator.hasNext()){
            int array[]=new int[2];
            int count=count(iterator.next());
            array=costAndSell(iterator.next());
            list.add((array[1]-array[0])*count);
        }*/
        for(int i=0;i<array1.length;i++){
            int array[]=new int[2];
            int count=count((int)array1[i]);
            array=costAndSell((int)array1[i]);
            list.add((array[1]-array[0])*count);
        }
        return list;
    }

    /**
     *查询各商品id对应的成本价和出售价
     * @param id
     * @return
     */
    public int[] costAndSell(int id) throws SQLException {
        int[] array=new int[2];
        conn= C3p0Util.getConnection();
        String sql="SELECT cost_price,selling_price from product where product_id=?;";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,id);
        rst=pstm.executeQuery();
        while(rst.next()) {
            array[0] = rst.getInt("cost_price");
            array[1] = rst.getInt("selling_price");
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return array;
    }
    public int count(int id) throws SQLException{
        conn= C3p0Util.getConnection();
        String sql="SELECT SUM(trade_number) from tradeinfo where product_id=?;";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,id);
        rst=pstm.executeQuery();
        int re = 0;
        while(rst.next()) {
             re = rst.getInt("SUM(trade_number)");
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return re;
    }

    /**
     * 根据id查询名称
     * @param id
     * @return
     */
    public String queryName(int id)throws SQLException{
        conn= C3p0Util.getConnection();
        String sql="select  product_name from product where product_id=?;";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,id);
        rst=pstm.executeQuery();
        String str=null;
        while(rst.next()) {
            str = rst.getString("product_name");
        }
        C3p0Util.closeResource(rst,pstm,conn);
        return str;
    }


}
