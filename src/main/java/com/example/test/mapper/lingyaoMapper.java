package com.example.test.mapper;

import com.example.test.pojo.lingyaodingdan;

import java.util.List;

public interface lingyaoMapper {
    void addlingyao(lingyaodingdan lingyaodingdan);
    List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan);
    void updateLy(lingyaodingdan lingyaodingdan);
    void deleteLy(lingyaodingdan lingyaodingdan);
}