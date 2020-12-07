package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.out;
import com.example.test.pojo.outdanhao;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;


import java.util.List;
import java.util.Map;
@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface outRecord {
    List<Map<String,Object>> selectAll();
    int addORecord(out out);
    int updateDrug(out out);
    int deleteOr(out out);
    List<Map<String,Object>> selectOr(out out);
    int updateOR(out out);
    int addoutsum(outdanhao outdanhao);

    List<Map<String,Object>> selectAllsum();
}