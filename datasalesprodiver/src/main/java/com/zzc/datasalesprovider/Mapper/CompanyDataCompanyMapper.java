package com.zzc.datasalesprovider.Mapper;

import com.zzc.datasalesprovider.Model.CompanyDataCompany;
import com.zzc.datasalesprovider.Model.CompanyDataCompanyWithBLOBs;
import com.zzc.datasalesprovider.Model.FilterCondition;

import java.util.List;

public interface CompanyDataCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyDataCompanyWithBLOBs record);

    int insertSelective(CompanyDataCompanyWithBLOBs record);

    List<CompanyDataCompanyWithBLOBs> selectByPrimaryKey();

    int updateByPrimaryKeySelective(CompanyDataCompanyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CompanyDataCompanyWithBLOBs record);

    int updateByPrimaryKey(CompanyDataCompany record);

    List<CompanyDataCompanyWithBLOBs> selectAllData(FilterCondition filterCondition);
}