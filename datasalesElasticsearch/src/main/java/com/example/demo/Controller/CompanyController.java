package com.example.demo.Controller;

import com.example.demo.Dao.CompanyService;
import com.example.demo.Model.Company;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    /**
     * 根据省市区以及行业分类过滤查询数据
     * @param Company 实体类
     * @return
     */
    @RequestMapping(value="/search", method= RequestMethod.POST)
    public List<Company> save(@RequestBody Company data) {
        List<Company> dataList = null;
        if(StringUtils.isNotEmpty(data.getProductions())) {
            dataList = companyService.searchCompany(data);
        }
        return dataList;
    }
}
