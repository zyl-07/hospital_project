package com.example.test.mapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;


import java.util.List;
import java.util.Map;
@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface caiwuMapper {
    int addcaiwu(Map<String, Object> map);
    List<Map<String,Object>> selectAll();
}
