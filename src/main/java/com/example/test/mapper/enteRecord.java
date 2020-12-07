package com.example.test.mapper;

import com.example.test.pojo.drugs;
import com.example.test.pojo.indanhao;
import com.example.test.pojo.put;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;
@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface enteRecord {
    int addERecord(put put);
    int updateDrug(put put);
    int deleteEr(put put);
    List<Map<String,Object>> selectEr(put put);
    List<Map<String,Object>> selectAll();
    int updateER(put put);
    int addInsum(indanhao indanhao);
    List<Map<String,Object>> selectAllsum();
}
