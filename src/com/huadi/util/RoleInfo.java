package com.huadi.util;

/**
 * @author 刘杰
 * @description 登录信息类
 * @date 2020/8/4 14:40
 * id:登录表id
 * phone：登录账号
 * password：登录密码
 */
public class RoleInfo {
    private int id;
    private String phoneNum;
    private String password;

    /**
     *
     */
    public RoleInfo() {
        super();
    }

    public RoleInfo(String phoneNum, String password) {
        this.phoneNum = phoneNum;
        this.password = password;
    }

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
