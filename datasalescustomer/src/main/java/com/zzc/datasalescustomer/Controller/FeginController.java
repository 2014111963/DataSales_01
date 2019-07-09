package com.zzc.datasalescustomer.Controller;

import com.zzc.datasalescustomer.Model.FilterCondition;
import com.zzc.datasalescustomer.Service.DataSalesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("/dataSales")
public class FeginController {

    @Autowired
    private DataSalesInterface dataSalesInterface;

    @GetMapping("/companyData")
    public JSONObject getCompanyData () {
        return dataSalesInterface.getCompanyData();
    }

    @PostMapping("/filterCompanyData")
    public JSONObject getFilterCompanyData (@RequestBody FilterCondition data) {
        return dataSalesInterface.getFilterCompanyData(data);
    }
}
