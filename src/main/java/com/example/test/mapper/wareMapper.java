package com.example.test.mapper;

import com.example.test.pojo.ware;

import java.util.List;

public interface wareMapper {
    void addWare(ware ware);
    List<ware> selectAll();
    void deleteWare(ware ware);
}
