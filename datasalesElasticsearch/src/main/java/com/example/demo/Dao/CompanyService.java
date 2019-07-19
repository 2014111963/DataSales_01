package com.example.demo.Dao;

import com.example.demo.Model.Company;

import java.util.List;

public interface CompanyService {
    void saveCompany(Company data);

    void saveCompany(List<Company> dataList);

    List<Company> searchCompany(Company data);
}
