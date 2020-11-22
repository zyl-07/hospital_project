package com.example.test.mapper;
import com.example.test.pojo.drugs;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface DrugsMapper {
    void insertdrug(drugs drug);
    List<Map<String,Object>> selectAll();
    List<drugs> selectdrug(drugs drug);
    int deletedrug(drugs drug);
    int updatedrug(drugs drug);
}
