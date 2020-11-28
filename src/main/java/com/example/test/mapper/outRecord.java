package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.out;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;
@Mapper
public interface outRecord {
    List<Map<String,Object>> selectAll();
    int addORecord(out out);
    int updateDrug(out out);
    int deleteOr(out out);
    List<Map<String,Object>> selectOr(out out);
    int updateOR(out out);
}