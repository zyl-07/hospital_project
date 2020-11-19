package com.example.test.services;

import com.example.test.pojo.drugsCheck;

import java.util.List;

public interface checkService {
    List<drugsCheck> selectCk(drugsCheck drugsCheck);
    int deleteCk(drugsCheck drugsCheck);
    int updateCk(drugsCheck drugsCheck);
    int addCk(drugsCheck drugsCheck);
}
