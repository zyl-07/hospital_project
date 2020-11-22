package com.example.test.services;

import com.example.test.pojo.put;

import java.util.List;
import java.util.Map;

public interface putService {
    int addEr(put put);
    List<Map<String,Object>> findAll();
    List<Map<String,Object>> selectEr(put put);
}
