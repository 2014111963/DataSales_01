package com.example.demo.Util;


import com.example.demo.Model.Company;

import java.util.ArrayList;
import java.util.List;

public class GetCompanyData {
    public static List<String> getCompanyData(Company data){
        List<String> listData = new ArrayList<>();
        listData.add(data.getName());
        listData.add(data.getProvince());
        listData.add(data.getCity());
        listData.add(data.getContact());
        listData.add(data.getPosition());
        listData.add(data.getTel());
        listData.add(data.getEmail());
        listData.add(data.getAddress());
        listData.add(data.getProductions());
        return listData;
    }
}
