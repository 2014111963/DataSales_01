package com.zzc.datasalescustomer.Controller;

import com.zzc.datasalescustomer.Service.DataSalesInterface;
import com.zzc.datasalescustomer.Util.FilterCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("/dataSales")
public class FeginController {

    @Autowired
    private DataSalesInterface dataSalesInterface;

    /**
     * 数据预览界面加载数据，查询出所以的数据
     * @return 所有数据
     */
    @GetMapping("/companyData")
    public JSONObject getCompanyData () {
        return dataSalesInterface.getCompanyData();
    }

    /**
     * 根据省市去以及行业模糊匹配条件过滤，查询数据
     * @param data
     * @return 查询出来的数据集
     */
    @PostMapping("/filterCompanyData")
    public JSONObject getFilterCompanyData (@RequestBody FilterCondition data) {
        return dataSalesInterface.getFilterCompanyData(data);
    }

    /**
     * 根据省市去以及行业模糊匹配条件过滤，下载数据
     * @param data
     * @return 下载响应结果
     */
    @PostMapping("/dataDownload")
    public JSONObject dataDownload (@RequestBody FilterCondition data) {
        return dataSalesInterface.dataDownload(data);
    }


}
