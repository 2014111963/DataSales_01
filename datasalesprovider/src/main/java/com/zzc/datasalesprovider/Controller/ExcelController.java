package com.zzc.datasalesprovider.Controller;

import com.zzc.datasalesprovider.Model.CompanyDataCompanyWithBLOBs;
import com.zzc.datasalesprovider.Model.FilterCondition;
import com.zzc.datasalesprovider.Service.CompanyDataService;
import com.zzc.datasalesprovider.Util.ExcelUtil;
import com.zzc.datasalesprovider.Util.GetCompanyData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class ExcelController {

    @Autowired
    CompanyDataService companyDataService;
    /**
     * Excel表格导出接口
     * http://localhost:8763/data/ExcelDownload
     * @param response response对象
     * @throws IOException 抛IO异常
     */
    @RequestMapping("/ExcelDownload")
    public void excelDownload(HttpServletResponse response, @Param("province") String province,
                              @Param("city") String city) throws IOException {
        List<List<String>> excelData = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("公司名称");head.add("省份");head.add("城市");head.add("地区");head.add("关键联系人");
        head.add("职位");head.add("电话");head.add("固定电话");head.add("邮箱");head.add("邮编");
        head.add("在营状态");head.add("成立时间");head.add("规模");head.add("注册资本");head.add("所属类别");
        head.add("地址");head.add("经营范围");
        FilterCondition data = new FilterCondition();
        data.setCity(city);
        data.setProvince(province);
        List<CompanyDataCompanyWithBLOBs> list = companyDataService.getFilterData(data);
        excelData.add(head);
        for(int i=0;i<list.size();i++) {
            excelData.add(GetCompanyData.getCompanyData(list.get(i)));
        }
        String sheetName = "公司信息";
        String fileName = "CompanyData.xls";
        ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 12);
    }
}
