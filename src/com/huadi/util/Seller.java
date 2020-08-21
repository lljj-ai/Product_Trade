package com.huadi.util;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/10 14:28
 * userId:买方id
 * name:买方姓名
 * age:买方年龄
 * sex:买方性别
 * area:地区
 */
public class Seller {
    private int userId;
    private String name;
    private int age;
    private String sex;
    private String area;
    private int tel;

    public Seller() {
    }

    public Seller(int userId) {
        this.userId = userId;
    }

    public Seller(String name, int age, String sex, String area, int tel) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.area = area;
        this.tel = tel;
    }

    public Seller(int userId, String name, int age, String sex, String area, int tel) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.area = area;
        this.tel = tel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
