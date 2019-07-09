package com.zzc.datasalesprovider.Model;

public class FilterCondition {

    private int id;

    private int pageNum;

    private String token;

    private String username; //每次查询带上用户名，即用户注册手机号码

    private int pageSize = 5;

    private String province;

    private String city;

    private String category; // 行业 模糊查询匹配

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getProvince() {
        return province;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
