package com.example.test.mapper;
import com.example.test.pojo.drugs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface DrugsMapper {
    void insertdrug(drugs drug);
    List<drugs> selectAll();
    List<drugs> selectdrug(drugs drug);
    void deletedrug(drugs drug);
    void updatedrug(drugs drug);
}
