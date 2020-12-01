package com.example.test.services;

import com.example.test.pojo.lingyaodingdan;

import java.util.List;

public interface lingyaoService {
    void add(lingyaodingdan lingyaodingdan);

    List<lingyaodingdan> findAll();

    List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan);

    void deleteLy(lingyaodingdan lingyaodingdan);

    void updateLy(lingyaodingdan lingyaodingdan);

    void addLy(lingyaodingdan lingyaodingdan);
}
