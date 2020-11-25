package com.example.test.services;

import com.example.test.pojo.drugsCheck;

import java.util.List;
import java.util.Map;

public interface checkService {
    List<Map<String,Object>> selectCk(drugsCheck drugsCheck);
    int deleteCk(drugsCheck drugsCheck);
    int updateCk(drugsCheck drugsCheck);
    int addCk(Map<String,Object> map);
    List<Map<String,Object>> selectAllCk();
}
