package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.out;


import java.util.List;

public interface outRecord {
    List<out> selectAll();
    void addORecord(out out);
    void updateDrug(out out);
    List<out> selectOr(out out);
}