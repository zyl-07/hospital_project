package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.put;

import java.util.List;
import java.util.Map;

public interface enteRecord {
    int addERecord(put put);
    int updateDrug(put put);
    int deleteEr(put put);
    List<Map<String,Object>> selectEr(put put);
    List<Map<String,Object>> selectAll();
    int updateER(put put);
}
