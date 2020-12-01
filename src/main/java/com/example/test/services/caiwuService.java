package com.example.test.services;

import java.util.List;
import java.util.Map;
public interface caiwuService {
    int addCw(Map<String, Object> map);
    List<Map<String,Object>> findAll();
}
