package com.example.test.services;

import com.example.test.pojo.ware;

import java.util.List;

public interface wareService {
    int addWare(ware ware);
    int deleteWare(ware ware);
    List<ware> selectAll();
}
