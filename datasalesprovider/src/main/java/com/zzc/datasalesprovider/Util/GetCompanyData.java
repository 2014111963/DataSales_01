package com.zzc.datasalesprovider.Util;


import com.zzc.datasalesprovider.Model.CompanyDataCompanyWithBLOBs;

import java.util.ArrayList;
import java.util.List;

public class GetCompanyData {
    public static List<String> getCompanyData(CompanyDataCompanyWithBLOBs data){
        List<String> listData = new ArrayList<>();
        listData.add(data.getName());
        listData.add(data.getProvince());
        listData.add(data.getCity());
        listData.add(data.getArea());
        listData.add(data.getContact());
        listData.add(data.getPosition());
        listData.add(data.getTel());
        listData.add(data.getFixedTelephone());
        listData.add(data.getEmail());
        listData.add(data.getZipCode());
        listData.add(data.getStatus());
        listData.add(data.getEstablished());
        listData.add(data.getNumberOfStaff());
        listData.add(data.getCapital());
        listData.add(data.getCategory());
        listData.add(data.getAddress());
        listData.add(data.getProductions());
        return listData;
    }
}
