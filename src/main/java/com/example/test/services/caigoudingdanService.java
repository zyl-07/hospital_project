package com.example.test.services;

import com.example.test.pojo.caigoudingdan;

import java.util.List;

public interface caigoudingdanService {
    int updateCG(caigoudingdan caigoudingdan);
    //int addCG(caigoudingdan caigoudingdan);
    int deleteCG(caigoudingdan caigoudingdan);
    List<caigoudingdan> selectCG(caigoudingdan caigoudingdan);
}
