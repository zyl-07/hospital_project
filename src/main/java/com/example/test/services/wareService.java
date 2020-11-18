package com.example.test.services;

import com.example.test.pojo.ware;

import java.util.List;

public interface wareService {
    void addWare(ware ware);
    void deleteWare(ware ware);
    List<ware> selectAll();
}
