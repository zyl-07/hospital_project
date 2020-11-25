package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.drugsCheck;
import org.apache.ibatis.annotations.Mapper;
import sun.applet.resources.MsgAppletViewer;

import java.util.List;
import java.util.Map;
@Mapper
public interface checkMapper {
    int addcheck(Map<String,Object> map);
    List<Map<String,Object>> selectCr(drugsCheck drugsCheck);
    List<Map<String,Object>> selectAll();
    int updateCkanddrug(drugsCheck drugsCheck);
    int deleteCk(drugsCheck drugsCheck);
    List<drugs> newCr(drugs drugs);
}
