package com.example.test.mapper;

import com.example.test.pojo.lingyaodingdan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface lingyaoMapper {
    int addlingyao(lingyaodingdan lingyaodingdan);
    List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan);
    int updateLy(lingyaodingdan lingyaodingdan);
    int deleteLy(lingyaodingdan lingyaodingdan);
    List<Map<String,Object>> selectAll();
}