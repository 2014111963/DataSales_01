package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Dao.CityESService;
import com.example.demo.Model.Entity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entity")
public class EntityController {


    @Autowired
    CityESService cityESService;

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@RequestBody Entity data) {
        if(data.getId()>0 && StringUtils.isNotEmpty(data.getName())) {
            List<Entity> addList = new ArrayList<Entity>();
            addList.add(data);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public List<Entity> save(@RequestParam("name") String name) {
        System.out.println(name);
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(name)) {
            entityList = cityESService.searchEntity(name);
        }
        return entityList;
    }
}
