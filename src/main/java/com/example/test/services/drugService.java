package com.example.test.services;
import com.example.test.pojo.drugs;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface drugService {
    int add(drugs drug);
    List<Map<String,Object>> findAll();
    List<drugs> selectdrug(drugs drug);
    int deletedrug(drugs drug);
    int updatedrug(drugs drug);
}
