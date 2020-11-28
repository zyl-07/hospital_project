package com.example.test.services;

import com.example.test.pojo.caigou;

import java.util.List;
import java.util.Map;

public interface caigouService {

    List<Map<String, Object>> findcaigou();
    List<Map<String,Object>> findcaigoudingdan() ;
    int addcaigou(caigou caigou);

    int updatecaigou(caigou caigou);

    int deletecaigou(caigou caigou);

    List<caigou> select(caigou caigou);
    // List<caigou> selectEr(caigou caigou);
}
