package com.example.test.mapper;

import com.example.test.pojo.drugsCheck;

import java.util.List;

public interface checkMapper {
    int addcheck(drugsCheck drugsCheck);
    List<drugsCheck> selectCr(drugsCheck drugsCheck);
    int updateCk(drugsCheck drugsCheck);
    int deleteCk(drugsCheck drugsCheck);
}
