package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.out;


import java.util.List;

public interface outRecord {
    List<out> selectAll();
    int addORecord(out out);
    int updateDrug(out out);
    List<out> selectOr(out out);
}