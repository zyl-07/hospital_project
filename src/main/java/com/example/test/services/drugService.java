package com.example.test.services;
import com.example.test.pojo.drugs;
import org.springframework.stereotype.Service;

import java.util.List;


public interface drugService {
    void add(drugs drug);
    List<drugs> findAll();
    List<drugs> selectdrug(drugs drug);
    void deletedrug(drugs drug);
    void updatedrug(drugs drug);
}
