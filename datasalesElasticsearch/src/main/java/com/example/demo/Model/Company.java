package com.example.demo.Model;

public class Company {
    private static final long serialVersionUID = -763638353551774166L;
    public static final String INDEX_NAME = "company_base_info_2";
    public static final String TYPE = "_doc";
    private Long id;
    private String name;
    private String productions;
    private String contact;
    private String position;
    private String tel;
    private String email;
    private String province;
    private String city;
    private String address;
    private int pageSize;

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProductions() {
        return productions;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setProductions(String productions) {
        this.productions = productions;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Company() {
        super();
    }

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
