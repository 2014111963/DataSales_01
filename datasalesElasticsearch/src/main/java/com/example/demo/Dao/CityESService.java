package com.example.demo.Dao;

import com.example.demo.Model.Entity;

import java.util.List;

public interface CityESService {

    void saveEntity(Entity data);

    void saveEntity(List<Entity> dataList);

    List<Entity> searchEntity(String searchContent);
}