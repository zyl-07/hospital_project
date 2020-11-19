package com.example.test.mapper;

import com.example.test.pojo.ware;

import java.util.List;

public interface wareMapper {
    int addWare(ware ware);
    List<ware> selectAll();
    int deleteWare(ware ware);
}
