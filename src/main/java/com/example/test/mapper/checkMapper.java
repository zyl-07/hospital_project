package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.drugsCheck;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;
@Mapper
public interface checkMapper {
    int addcheck(drugsCheck drugsCheck);
    List<Map<String,Object>> selectCr(drugsCheck drugsCheck);
    List<Map<String,Object>> selectAll();
    int updateCkanddrug(drugsCheck drugsCheck);
    int deleteCk(drugsCheck drugsCheck);
    List<drugs> newCr(drugs drugs);
//    更新药品
    int updateDrug(drugsCheck drugsCheck);
}
