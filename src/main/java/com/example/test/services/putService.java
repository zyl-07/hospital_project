package com.example.test.services;

import com.example.test.pojo.put;

import java.util.List;

public interface putService {
    int addEr(put put);
    List<put> findAll();
    List<put> selectEr(put put);
}
