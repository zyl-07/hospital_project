package com.example.test.mapper;

import com.example.test.pojo.caigoudingdan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface caigoudingdanMapper {
   List<caigoudingdan> selectCG(caigoudingdan caigoudingdan) ;
   int deleteCG(caigoudingdan caigoudingdan) ;
   int updateCG(caigoudingdan caigoudingdan) ;
  // int addcheCG(caigoudingdan caigoudingdan) ;
}
