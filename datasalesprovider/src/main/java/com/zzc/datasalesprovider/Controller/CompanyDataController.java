package com.zzc.datasalesprovider.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzc.datasalesprovider.Model.CompanyDataCompanyWithBLOBs;
import com.zzc.datasalesprovider.Model.FilterCondition;
import com.zzc.datasalesprovider.Service.CompanyDataService;
import com.zzc.datasalesprovider.Util.ExcelUtil;
import com.zzc.datasalesprovider.Util.FieldMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/dataSales")
public class CompanyDataController {

    @Autowired
    CompanyDataService companyDataService;

    HttpServletResponse response;
    /**
     * 根据省份，市区，以及行业匹配 查询符合条件的数据
     * @param data 过滤条件实体类
     * @return
     */
    @PostMapping("/dataDownload")
    public JSONObject dataDownload(@RequestBody FilterCondition data){
        JSONObject json = new JSONObject();
        List<CompanyDataCompanyWithBLOBs> list = companyDataService.getAllData(data);
        FieldMap.setFieldMap();
        try {
            ExcelUtil.listToExcel(list, FieldMap.getFieldMap(), "下载数据", response);
            System.out.println("下载成功！");
        }catch (Exception e){
            System.out.println("下载失败！");
            e.toString();
        }
        if(list != null) {
            json.put("provider","8763");
            json.put("data", list);
            json.put("code", "200");
            json.put("msg","下载成功！");
        }
        return json;
    }
    /**
     * 根据省份，市区，以及行业匹配 查询符合条件的数据
     * @param data 过滤条件实体类
     * @return
     */
    @PostMapping("/companyData")
    public JSONObject getAllData(@RequestBody FilterCondition data){
        System.out.println("8763");
        JSONObject json = new JSONObject();
        List<CompanyDataCompanyWithBLOBs> list = companyDataService.getAllData(data);
        if(list != null) {
            json.put("provider","8763");
            json.put("data", list);
            json.put("code", "200");
        }
        return json;
    }

    /**
     * 数据预览界面加载数据，查询出所以的数据
     * @return
     */
    @GetMapping("/companyDataId")
    public JSONObject getByPrimaryKey(){
        JSONObject json = new JSONObject();
        List<CompanyDataCompanyWithBLOBs> list = companyDataService.selectByPrimaryKey();
        if(list != null) {
            json.put("provider","8763");
            json.put("data", list);
            json.put("code", "200");
        }
        return json;
    }
}
