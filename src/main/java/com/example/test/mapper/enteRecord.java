package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.put;

import java.util.List;

public interface enteRecord {
    void addERecord(put put);
    void updateDrug(put put);
    List<put> selectEr(put put);
    List<put> selectAll();
}
