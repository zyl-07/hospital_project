package com.example.test.mapper;

import com.example.test.pojo.caigou;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface caigouRecord {
    int addERecord(caigou caigou);
    List<caigou> selectcaigou();
//    List<caigou> selectEr(caigou caigou);
}
