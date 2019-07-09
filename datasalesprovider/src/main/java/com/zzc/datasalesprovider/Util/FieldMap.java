package com.zzc.datasalesprovider.Util;

import java.util.LinkedHashMap;

public class FieldMap {
    public static LinkedHashMap<String,String> fieldMap = new LinkedHashMap<String,String>();

    public static LinkedHashMap<String, String> getFieldMap() {
        return fieldMap;
    }
    public static void setFieldMap() {
        fieldMap.put("number","序号");
        fieldMap.put("name","公司名称");
        fieldMap.put("province","省份");
        fieldMap.put("city","城市");
        fieldMap.put("area","城区");
        fieldMap.put("contact","企业关键人");
        fieldMap.put("position","职位");
        fieldMap.put("tel","电话");
        fieldMap.put("fixed_telephone","固定电话");
        fieldMap.put("email","邮箱");
        fieldMap.put("address","地址");
        fieldMap.put("zip_code","邮编");
        fieldMap.put("status","在营与否");
        fieldMap.put("productions","经营范围");
        fieldMap.put("category","行业类型");
        fieldMap.put("capital","注册资本");
        fieldMap.put("number_of_staff","人员规模");
    }
}
