package com.zzc.datasalesprovider.Service;

import com.zzc.datasalesprovider.Model.CompanyDataCompanyWithBLOBs;
import com.zzc.datasalesprovider.Model.FilterCondition;

import java.util.List;

public interface CompanyDataService {

    public List<CompanyDataCompanyWithBLOBs> getFilterData(FilterCondition data);

    List<CompanyDataCompanyWithBLOBs> getAllData();
}
