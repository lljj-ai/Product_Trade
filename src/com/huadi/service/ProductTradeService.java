package com.huadi.service;

import com.huadi.util.TradeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘杰
 * @description 商品交易显示
 * @date 2020/8/10 15:20
 */
public interface ProductTradeService {
    /**
     * 商品交易信息
     * @return
     */
    public List<TradeInfo> tradeProduct() throws SQLException;

    /**
     *商品交易次数
     * @return
     */
    //public List<Integer> tradeTimes() throws SQLException;

    /**
     * 商品利润
     * @return
     */
    public List<Integer> tradeProfit() throws SQLException;

}
