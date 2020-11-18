package com.example.test.mapper;

import com.example.test.pojo.drugsCheck;

import java.util.List;

public interface checkMapper {
    void addcheck(drugsCheck drugsCheck);
    List<drugsCheck> selectCr(drugsCheck drugsCheck);
    void updateCk(drugsCheck drugsCheck);
    void deleteCk(drugsCheck drugsCheck);
}
