package com.huadi.util;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/10 14:46
 * productId:商品id
 * productName:商品名称
 * costPrice:商品成本价
 * sellingPrice:商品销售价
 * manufacture:开发商
 */
public class Product {
    private int productId;
    private String productName;
    private int costPrice;
    private int sellingPrice;
    private String manufacture;

    public Product() {
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public Product(String productName, int costPrice, int sellingPrice, String manufacture) {
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.manufacture = manufacture;
    }

    public Product(int productId, String productName, int costPrice, int sellingPrice, String manufacture) {
        this.productId = productId;
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.manufacture = manufacture;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
