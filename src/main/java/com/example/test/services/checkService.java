package com.example.test.services;

import com.example.test.pojo.drugsCheck;

import java.util.List;

public interface checkService {
    List<drugsCheck> selectCk(drugsCheck drugsCheck);
    void deleteCk(drugsCheck drugsCheck);
    void updateCk(drugsCheck drugsCheck);
    void addCk(drugsCheck drugsCheck);
}
