package com.huadi.util;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/10 14:43
 * tradeId:交易id
 * productId:产品id
 * userId:卖方id
 * tradeNumber:交易数量
 */
public class TradeInfo {
    private int tradeId;
    private int productId;
    private int userId;
    private int tradeNumber;
    private int tradeTimes;
    private int profit;
    private String productName;
    public TradeInfo() {
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(int tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public int getTradeTimes() {
        return tradeTimes;
    }

    public void setTradeTimes(int tradeTimes) {
        this.tradeTimes = tradeTimes;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
