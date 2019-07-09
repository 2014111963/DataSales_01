package com.zzc.datasalesprovider.ServiceIml;

import com.zzc.datasalesprovider.Mapper.CompanyDataCompanyMapper;
import com.zzc.datasalesprovider.Model.CompanyDataCompanyWithBLOBs;
import com.zzc.datasalesprovider.Model.FilterCondition;
import com.zzc.datasalesprovider.Service.CompanyDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CompanyDataService")
public class CompanyDataServiceIml implements CompanyDataService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyDataServiceIml.class);

    @Autowired
    CompanyDataCompanyMapper companyDataCompanyMapper;
    
    @Override
    public List<CompanyDataCompanyWithBLOBs> getFilterData(FilterCondition data){
        return companyDataCompanyMapper.selectAllData(data);
    }

    @Override
    public List<CompanyDataCompanyWithBLOBs>  getAllData(){
        return companyDataCompanyMapper.selectByPrimaryKey();
    }
}
