package com.example.test.services;

import com.example.test.pojo.out;
import com.example.test.pojo.outdanhao;

import java.util.List;
import java.util.Map;

public interface outService {

    int addOr(out out);
    List<Map<String,Object>> findAll();
    List<Map<String,Object>> selectOr(out out);
    int updateOr(out out);
    int deleteOr(out out);
    int addsum(outdanhao outdanhao);
}
