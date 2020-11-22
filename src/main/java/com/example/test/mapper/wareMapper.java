package com.example.test.mapper;

import com.example.test.pojo.ware;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface wareMapper {
    int addWare(ware ware);
    List<ware> selectAll();
    int deleteWare(ware ware);
}
