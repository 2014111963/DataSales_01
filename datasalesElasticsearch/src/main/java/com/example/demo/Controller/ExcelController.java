package com.example.demo.Controller;

import com.example.demo.Dao.CompanyService;
import com.example.demo.Model.Company;
import com.example.demo.Util.ExcelUtil;
import com.example.demo.Util.GetCompanyData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class ExcelController {

    @Autowired
    CompanyService companyService;

    /**
     * 根据省市区以及行业分类过滤查询数据
     * @param Company 实体类
     * @return
     */
    @RequestMapping(value="/search", method= RequestMethod.POST)
    public List<Company> save(@RequestBody Company data) {
        System.out.println(data.getProductions());
        List<Company> dataList = null;
        if(StringUtils.isNotEmpty(data.getProductions())) {
            dataList = companyService.searchCompany(data);
        }
        return dataList;
    }

    /**
     * Excel表格导出接口
     * http://localhost:8762/data/ExcelDownload
     * @param response response对象
     * @throws IOException 抛IO异常
     */
    @RequestMapping("/ExcelDownload")
    public void excelDownload(HttpServletResponse response, @Param("province") String province,
                              @Param("city") String city, @Param("productions") String productions,
                              @Param("tel") String tel) throws IOException {
        List<List<String>> excelData = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("公司名称");head.add("省份");head.add("城市");head.add("地区");head.add("关键联系人");
        head.add("职位");head.add("电话");head.add("邮箱");head.add("经营范围");
        Company data = new Company();
        data.setCity(city);  //参数设置城市
        data.setProvince(province);  // 参数设置省份
        data.setProductions(productions);  //参数设置行业查找
        data.setTel(tel);  // 参数设置是否有电话
        data.setPageSize(1000);  // 参数设置是否有电话
        List<Company> list = companyService.searchCompany(data);
        excelData.add(head);
        for(int i=0;i<list.size();i++) {
            excelData.add(GetCompanyData.getCompanyData(list.get(i)));
        }
        String sheetName = "公司信息";
        String fileName = "CompanyData.xls";
        ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 12);
    }
}
