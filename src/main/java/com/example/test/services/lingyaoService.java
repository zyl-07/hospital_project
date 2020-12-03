package com.example.test.services;

import com.example.test.pojo.lingyaodingdan;

import java.util.List;
import java.util.Map;

public interface lingyaoService {
    void add(lingyaodingdan lingyaodingdan);

    List<Map<String,Object>> findAll();

    List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan);

    int deleteLy(lingyaodingdan lingyaodingdan);

    int updateLy(lingyaodingdan lingyaodingdan);

    int addLy(lingyaodingdan lingyaodingdan);
}
