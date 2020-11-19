package com.example.test.services;

import com.example.test.pojo.out;

import java.util.List;

public interface outService {

    int addOr(out out);
    List<out> findAll();
    List<out> selectOr(out out);
}
