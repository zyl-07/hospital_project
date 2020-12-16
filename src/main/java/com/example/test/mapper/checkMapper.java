package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.drugsCheck;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;
@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface checkMapper {
    int addcheck(drugsCheck drugsCheck);
    List<Map<String,Object>> selectCr(drugsCheck drugsCheck);
    List<Map<String,Object>> selectAll();
    int updateCkanddrug(drugs drugs);
    int deleteCk(drugsCheck drugsCheck);
    List<drugs> newCr(drugs drugs);
//    更新药品
    int updateDrug(drugsCheck drugsCheck);
}
