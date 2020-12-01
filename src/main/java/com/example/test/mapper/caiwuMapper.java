package com.example.test.mapper;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;
@Mapper
public interface caiwuMapper {
    int addcaiwu(Map<String, Object> map);
    List<Map<String,Object>> selectAll();
}
