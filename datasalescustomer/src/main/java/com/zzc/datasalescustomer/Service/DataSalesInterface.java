package com.zzc.datasalescustomer.Service;


import com.alibaba.fastjson.JSONObject;
import com.zzc.datasalescustomer.Configuration.FooConfiguration;
import com.zzc.datasalescustomer.Util.FilterCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "datasalesprovider", configuration = FooConfiguration.class)
public interface DataSalesInterface {

    @GetMapping("/dataSales/allCompanyData")
    JSONObject getCompanyData();

    @PostMapping("/dataSales/companyData")
    JSONObject getFilterCompanyData(@RequestBody FilterCondition data);

    @PostMapping("/dataSales/dataDownload")
    JSONObject dataDownload(@RequestBody FilterCondition data);
}